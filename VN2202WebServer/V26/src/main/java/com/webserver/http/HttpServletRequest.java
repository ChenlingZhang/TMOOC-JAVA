package com.webserver.http;

import static com.webserver.http.HttpContext.CR;
import static com.webserver.http.HttpContext.LF;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求对象
 * 该类的每一个实例用于表示HTTP协议规定的客户端发送过来的一个
 * 请求内容.
 * 每个请求由三部分组成:
 * 请求行,消息头,消息正文
 */
public class HttpServletRequest {
    private Socket socket;
    //请求行相关的信息
    private String method;//请求方式
    private String uri;//抽象路径
    private String protocol;//协议版本
    private String requestURI;//封装uri中"?"左边的请求部分
    private String queryString;//封装uri中"?"右边的参数部分
    //封装参数中的每一组参数名和参数值
    private Map<String,String> parameters = new HashMap<>();
    //存储消息头相关信息 key是消息头的名字 value是对应消息头的值
    private Map<String,String> headers = new HashMap<>();
    /*
     * 实例化请求对象的过程也是解析的过程
     */
    public HttpServletRequest(Socket socket) throws IOException, EmptyRequestException {
        this.socket = socket;
        //1.1解析请求行
        parseRequestLine();
        //1.2解析消息头
        parseHeaders();
        //1.3解析消息正文
        parseContent();
    }
    /**
     * 解析请求行
     */
    private void parseRequestLine() throws IOException, EmptyRequestException {
        String line = readLine();//读一行
        //如果请求行是一个空字符串,则说明本次请求是空请求
        if (line.isEmpty()){
            //对外抛出一个异常(自定义异常,空请求异常)
            throw new EmptyRequestException();
        }
        System.out.println("第一行内容(消息行):"+line);
        //将请求行内容使用正则表达式通过空格进行拆分
        String[] data = line.split("\\s");
        method = data[0];
        uri = data[1];
        protocol = data[2];
        parseUri();
        System.out.println("请求方式method:"+method);
        System.out.println("抽象路径uri:"+uri);
        System.out.println("协议版本protocol:"+protocol);
    }
    /*
     * 进一步解析uri
     */
    private void parseUri(){
        /*
         *  uri是有两种情况: 1:不含参数的 2:含参数的
         *  例如:
         * 不含参数的:/myweb/reg.html
         * 含有参数的:/myweb/reg?username=laoan&password=1234&nickname=anan&age=16
         * 处理方式:
         *  1:若不含参数,则直接将uri的值赋值给requestURI
         *  2:若含参数
         *      2.1:先将uri按照"?"拆分为请求部分和参数部分
         *          将请求部分赋值给requestURI
         *          将参数部分赋值给queryString
         *      2.2:将参数部分queryString通过"&"拆分出每一组的参数
         *          每组参数再按照"="拆分,分为参数名和参数值
         *          并将参数名当做key,参数值当做value,保存到parameters这个Map中
         *      允许页面输入框空着,这种情况该参数的值为null存入到parameters中即可
         */
        String[] data = uri.split("\\?");//先将uri按照"?"拆分为请求部分和参数部分
        // /myweb/reg
        requestURI = data[0];//将请求部分赋值给requestURI
        if (data.length>1){//若含参数
            //username=laoan&password=1234&nickname=anan&age=16
            queryString = data[1];//参数部分赋值给queryString
            //[username=laoan,password=1234,nickname=anan,age=16]
            parseParameters(queryString);
        }
        System.out.println("请求部分requestURI:"+requestURI);
        System.out.println("参数部分queryString:"+queryString);
        System.out.println("参数数组parameters:"+parameters);
    }
    //解析参数
    private void parseParameters(String line){
        //先进行转码
        try {
            line = URLDecoder.decode(line, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String[] data = line.split("&");
        for (String para : data) {
            String[] paras = para.split("=");//每组参数再按照"="拆分,分为参数名和参数值
            //如果不含参数,根据=分割,就会生成只有一个参数的数组,所以需要考虑此种情况,如果有一个参数,就将value置为null
            parameters.put(paras[0],paras.length>1?paras[1]:null);
        }
    }
    /**
     * 解析消息头
     */
    private void parseHeaders() throws IOException {
        while (true){
            String line = readLine();
            if (line.isEmpty()){//若读取的字符串为空串,说明单独读取了回车+换行
                //if(line.length()==0)
                //if("".equals(line))
                break;
            }
            System.out.println("消息头:"+line);
            //Host: localhost:8088
            //将消息头的名字和值进行拆分,需要使用正则表达式根据冒号+空格拆分
            String[] data = line.split(":\\s");
            headers.put(data[0],data[1]);
        }
    }
    /**
     * 解析消息正文
     */
    private void parseContent() throws IOException {
        System.out.println("开始解析消息正文...");
        //通过判断请求中的消息头是否包含Content-Length来确定是否有正文
        if (headers.containsKey("Content-Length")){
            int contentLength = Integer.parseInt(headers.get("Content-Length"));
            System.out.println("消息正文长度:"+contentLength);
            //基于消息正文长度来创建一个数组,用于消息正文的块级读取
            byte[] contentData = new byte[contentLength];
            InputStream in = socket.getInputStream();
            in.read(contentData);
            String contentType = headers.get("Content-Type");
            //如果Content-Type的值是application/x-www-form-urlencoded,则消息正文一定是字符串,而且是key=value
            //usernamne=laoan
            if ("application/x-www-form-urlencoded".equals(contentType)){
                //将字节数组转换为字符串
                String line = new String(contentData,
                        StandardCharsets.ISO_8859_1);
                System.out.println("正文内容:"+line);
                parseParameters(line);
            }
        }
    }
    private String readLine() throws IOException {
        InputStream in = socket.getInputStream();
        StringBuilder builder = new StringBuilder();
        int d;
        //pre上一次读取的字符,cur是本次读取的字符
        char pre = 'a',cur = 'a';
        while ((d = in.read())!=-1){
            cur = (char)d;//将本次读取的字节转换为字符赋值给cur
            if ( pre==CR & cur==LF){//连续读到了回车加换行
                break;
            }
            builder.append(cur);//将本次读取的字符拼接到StringBuilder中
            pre = cur;//拼接完之后,本次读取的字符变为上一次读取的字符
        }
        String line = builder.toString().trim();
        return line;
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getProtocol() {
        return protocol;
    }

    /*
     * 根据给定的消息头的名字,返回对应的消息头的值
     * 方法参数定义作用用来接收用户指定的消息头名字
     * 方法返回值作用用来返回对应的消息头的值
     */
    public String getHeaders(String name) {
        return headers.get(name);
    }
    public String getRequestURI() {
        return requestURI;
    }
    public String getQueryString() {
        return queryString;
    }
    /*
     * 根据给定的参数名获取对应的参数值
     * @param name 参数名:username
     * @return 参数值:laoan
     */
    public String getParameters(String name){
        return parameters.get(name);
    }
}
