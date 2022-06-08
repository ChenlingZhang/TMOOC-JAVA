package http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 响应对象
 * 该类的每一个实例用于表示一个HTTP协议规定的响应内容
 *
 */
public class HttpServletResponse {
    private int statusCode = 200;
    private File contentFile;
    private String statusResult = "OK"; // 状态描述
    private Socket socket;
    private Map<String, String> headers = new HashMap<>();

    public HttpServletResponse(Socket socket){
        this.socket = socket;
    }

    /**
     * 发送响应
     * 将当前响应对象内容按照标准的格式发送给客户端
     */
    public void response() throws IOException {
        // 发送状态行
        sendStatusLine();
        // 发送响应头
        sendHeaders();
        // 单独的回车+换行
        printLine("");
        // 发送响应正文
        sendContent();
    }
    private void sendStatusLine() throws IOException {
        String line = "HTTP/1.1" + " " + statusCode + " " + statusResult;
        printLine(line);
    }

    private void sendHeaders() throws IOException {
        Set<Map.Entry<String, String>> entrySet = headers.entrySet();
        for (Map.Entry<String,String> element: entrySet) {
            String name = element.getKey();
            String value = element.getValue();
            String line = name + ": " + value;
            printLine(line);
            System.out.println("响应头: " + line);
        }
    }

    private void sendContent() throws IOException {
        OutputStream out = socket.getOutputStream();
        byte[] content = new byte[1024*10];
        int len;
        // 创建输入流读取 index.html
        try(FileInputStream fis = new FileInputStream(contentFile)){
            while ((len=fis.read(content))!=-1){
                out.write(content,0,len);
            }
        }
    }

    /**
     * 发送字符串给客户端
     * @param line
     */
    private void printLine(String line) throws IOException {
        OutputStream out = socket.getOutputStream();
        byte[] data = line.getBytes(StandardCharsets.ISO_8859_1);
        out.write(data);
        out.write(13); // 发送回车符
        out.write(10); // 发送换行符
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public File getContentFile() {
        return contentFile;
    }

    public void setContentFile(File contentFile) {
        this.contentFile = contentFile;
    }

    public String getStatusResult() {
        return statusResult;
    }

    public void setStatusResult(String statusResult) {
        this.statusResult = statusResult;
    }

    /**
     * 添加一个要发送的响应头
     * 接收用户输入的响应头的名字和响应头的值，将名字设为key将值作为value
     * 存入到headers中
     */
    public void addHeaders(String name, String value){
        this.headers.put(name,value);
    }

}
