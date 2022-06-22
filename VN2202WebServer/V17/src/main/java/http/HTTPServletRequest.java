package http;

import static http.HttpContext.CR;
import static http.HttpContext.LF;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HTTPServletRequest {

    private Socket socket;
    // 请求行相关信息
    private String method;
    private String url;
    private String protocol;

    private String requestUrl; // 封装URI中？左边的部分
    private String queryString; // 封装URI中？右边的部分
    private Map<String, String> parameter = new HashMap<>(); // 封装参数中的每一组参数

    //存储消息头的信息，key为消息头的名字 value为消息头的值
    private Map<String, String> headers = new HashMap<>();

    /**
     * 实例化请求对象的过程也是解析的过程，
     * 在创建HTTPServeletRequest实例时，会调用构造方法，自己解析
     */
    public HTTPServletRequest(Socket socket) throws IOException, EmptyRequestException {
        this.socket = socket;
        // 解析请求行
        parseRequestLine();
        // 解析消息头
        parseHeaders();
    }

    /**
     * 解析请求行
     */
    private void parseRequestLine() throws IOException, EmptyRequestException {
        String line = readLine();
        // 如果请求行是一个空字符串，则说明本次请求是空请求
        if (line.isEmpty()) {
            throw new EmptyRequestException();
        }
        System.out.println("第一行 " + line);
        //请求行相关的信息
        // 使用正则表达式通过空格<\\s>进行拆分
        String[] data = line.split("\\s");
        method = data[0];
        url = data[1];
        protocol = data[2];
        parseUri();
        System.out.println("method: " + method + "\n" + "abstract url: " + url + "\n" + "protocol: " + protocol + "\n");

    }

    private void parseUri() {
        String[] data = url.split("\\?");
        requestUrl = data[0];
        if (data.length > 1) {
            queryString = data[1];
            data = queryString.split("&");
            for (String para : data) {
                String[] set = para.split("=");
                parameter.put(set[0], set.length > 1 ? set[1] : null);
            }
        } else {
            requestUrl = url;
        }
        System.out.println("Request Uri: " + requestUrl);
        System.out.println("QueryString: " + queryString);
        System.out.println("Parameters: " + parameter);
    }

    /**
     * 解析消息头
     */
    private void parseHeaders() throws IOException {
        while (true) {
            String line = readLine();
            if (line.isEmpty()) {
                // 判断是否获取到连续的回车+空字符串
                break;
            }
            // 将消息头的名字和值进行拆分，需要使用正则表达式+空格进行拆分
            String[] data = line.split(":\\s");
            headers.put(data[0], data[1]);
        }
        headers.forEach(
                (k, v) -> System.out.println("消息头: " + k + " 内容: " + v)
        );
    }

    /**
     * 解析消息正文
     */
    private void parseContent() {

    }

    private String readLine() throws IOException {
        InputStream in = socket.getInputStream();
        StringBuilder builder = new StringBuilder();
        int d;
        char pre = 'a', cur = 'b';
        while ((d = in.read()) != -1) {
            cur = (char) d;
            if (pre == CR && cur == LF) {
                break;
            }
            builder.append(cur);
            pre = cur;
        }
        return builder.toString().trim();
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getProtocol() {
        return protocol;
    }

    /**
     * 根据给定的消息头的名字，返回对应的消息头的值
     * 方法参数定义作用用来接收用户指定的消息头
     *
     * @return 返回对应的消息头的值
     */
    public String getHeaders(String name) {
        return headers.get(name);
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getParameters(String name) {
        return parameter.get(name);
    }
}
