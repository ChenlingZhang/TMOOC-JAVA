package http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 响应对象
 * 该类的每一个实例用于表示一个HTTP协议规定的响应内容
 *
 */
public class HttpServletResponse_V1 {
    private int statusCode = 200;
    private File contentFile;
    private String statusResult = "OK"; // 状态描述
    private Socket socket;

    public HttpServletResponse_V1(Socket socket){
        this.socket = socket;
    }

    /**
     * 发送响应
     * 将当前响应对象内容按照标准的格式发送给客户端
     */
    public void response() throws IOException {
        // 发送状态行
        String line = "HTTP/1.1" + " " + statusCode + " " + statusResult;
        printLine(line);
        // 发送响应头
        line = "Content-Type: text/html";
        printLine(line);
        line = "Content-Length: " + contentFile.length();
        printLine(line);
        // 单独的回车+换行
        printLine("");
        // 发送响应正文
        OutputStream out = socket.getOutputStream();
        byte[] content = new byte[1024*10];
        int len;
        // 创建输入流读取 index.html
        FileInputStream fis = new FileInputStream(contentFile);
        while ((len=fis.read(content))!=-1){
            out.write(content,0,len);
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
}
