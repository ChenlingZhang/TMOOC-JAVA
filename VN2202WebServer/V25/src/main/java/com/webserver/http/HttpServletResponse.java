package com.webserver.http;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.webserver.http.HttpContext.CR;
import static com.webserver.http.HttpContext.LF;

/**
 * 响应对象
 * 该类的每一个实例用于表示一个HTTP协议规定的响应内容
 * 每个响应由三部分组成
 * 状态行,响应头,响应正文
 */
public class HttpServletResponse {
    //声明状态行的相关信息
    private int statusCode = 200;//状态代码
    private String statusReason = "OK";//状态描述
    //声明响应头的相关信息
    //key:响应头的名字 value:响应头的值
    private Map<String, String> headers = new HashMap<>();
    private Socket socket;
    //响应正文的相关信息
    private File contentFile;
    /*
     * 使用字节数组输出流中的字节数组作为正文内容
     * ByteArrayOutputStream 是一个低级流,内部维护了一个字节数组
     * 通过这个流写出的数据都存储到这个数组中
     * */
    private ByteArrayOutputStream baos;
    private byte[] contentData;//保存baos中byte数组的内容(动态页面数据)
    //返回一个字节数组输出流,通过该留输出写出的字节当做正文发送给浏览器
    public OutputStream getOutputStream() {
        if (baos == null) {//防止这个baos对象创建多次
            baos = new ByteArrayOutputStream();
        }
        return baos;
    }

    /*
     * 对外提供一个获取按行输入字符串的流对象,
     * 只不过需要自己进行流对象的链接
     * */
    public PrintWriter getWriter() {
        //获取一个字节数组输出流(低级流)
        OutputStream out = getOutputStream();
        //获取一个转换流,用来链接低级字节流和字符流
        OutputStreamWriter osw =
                new OutputStreamWriter(out, StandardCharsets.UTF_8);
        //获取一个缓冲流,加快写的效率
        BufferedWriter bw = new BufferedWriter(osw);
        //获取写入输出字符流,可以按行写入,并且开启自动行刷新
        //现在按行写入,缓冲流有缓冲区,缓冲区不满,就不会写出数据,所以必须开启行刷新
        PrintWriter pw = new PrintWriter(bw, true);
        return pw;
    }
    /*
    * 设置响应头Content-Type
    * */
    public void setContentType(String mime){
        addHeaders("Content-Type", mime);
    }
    public HttpServletResponse(Socket socket) {
        this.socket = socket;
    }

    /*
     * 发送响应
     * 将当前响应对象内容按照标准的格式发送给客户端
     */
    public void response() throws IOException {
        /*
         * 服务器给浏览器返回的响应信息内容
         * HTTP/1.1 200 OK(CRLF) 状态行
         * Content-Type: text/html(CRLF) 响应头
         * Content-Length: 1234(CRLF)(CRLF)
         * 1010001010101...... 响应正文
         */
        sendBefore();
        //3.1发送状态行
        sendStatusLine();
        //3.2发送响应头
        sendHeaders();
        //3.3发送响应正文(要发送的网页的所有内容)
        sendContent();
    }
    /*
    * 响应发送前的准备工作
    * */
    private void sendBefore(){
        if (baos!=null){//不为null,说明处理请求的环节用过它,用过它就说明写出过动态数据
            //获取baos内部的字节数组(数组中存储这动态页面的字节)
            contentData = baos.toByteArray();
            //根据该数组的长度设置响应头Content-Length
            addHeaders("Content-Length", contentData.length+"");
        }
    }
    private void sendStatusLine() throws IOException {
        String line = "HTTP/1.1" + " " + statusCode + " " + statusReason;
        println(line);
    }

    private void sendHeaders() throws IOException {
//        String line = "Content-Type: text/html";
//        println(line);
//        line = "Content-Length: " + contentFile.length();
//        println(line);
        //遍历headers,将所有的响应头发送给浏览器
        //headers {Content-Type=text/html}
        Set<Map.Entry<String, String>> entrySet = headers.entrySet();
        for (Map.Entry<String, String> e : entrySet) {
            String name = e.getKey();//获取响应头的名字 Content-Type
            String value = e.getValue();//获取响应头的值 text/html
            //生成响应头的格式 Content-Type: text/html
            String line = name + ": " + value;
            println(line);
            System.out.println("响应头:" + line);
        }
        //单独再加一个回车+换行,标志响应头部分结束
        println("");
    }

    private void sendContent() throws IOException {
        //创建输入流读取index.html
        OutputStream out = socket.getOutputStream();
        if (contentData != null){//有动态数据
            //将动态数据发送给浏览器
            out.write(contentData);
        }else if (contentFile != null) {
            byte[] buf = new byte[1024 * 10];
            int len;
            try (
                    FileInputStream fis = new FileInputStream(contentFile);
            ) {
                while ((len = fis.read(buf)) != -1) {
                    out.write(buf, 0, len);
                }
            }
        }

    }

    //发送字符串给客户端
    private void println(String line) throws IOException {
        OutputStream out = socket.getOutputStream();
        byte[] data = line.getBytes(StandardCharsets.ISO_8859_1);
        out.write(data);
        out.write(CR);//发送回车符
        out.write(LF);//发送换行符
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public File getContentFile() {
        return contentFile;
    }

    public void setContentFile(File contentFile) {
        this.contentFile = contentFile;
        /*
         * 实现资源的后缀名设置正确的Content-Type的值
         * 思路:
         * 1:根据file获取其表示的文件名
         * 2:根据文件名截取出后缀名
         * 3:根据后缀名设置对应的Content-Type的值
         */
        //获取文件的名字 a.image.png
        String fileName = contentFile.getName();
        //获取后缀名 png
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        //根据后缀提取对应的mime值
        String mime = HttpContext.getMimeType(ext);
        addHeaders("Content-Type", mime);
        addHeaders("Content-Length", contentFile.length() + "");
    }

    /**
     * 添加一个要发送的响应头
     * 接收用户输入的响应头的名字和响应头的值,然后将名字做为key,将值作为value,
     * 存入到headers中
     */
    public void addHeaders(String name, String value) {
        this.headers.put(name, value);
    }
}
