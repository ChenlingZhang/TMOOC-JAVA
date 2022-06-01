package core;

import http.HTTPServletRequest;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 该线程任务类，负责与指定的客户端完成HTTP
 */
public class ClientHandle implements Runnable {
    private Socket socket;
    public ClientHandle(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 解析请求
            HTTPServletRequest request = new HTTPServletRequest(socket);

            // 处理请求
            String path = request.getUrl();
            System.out.println("Abstract Path: " + path);
            // 发送响应
            File static_dir = new File(ClientHandle.class.getClassLoader().getResource("./static").toURI());
            /*
            指定父级目录，防止子级目录报错，影响父级目录。报空指针错误
             */
            File file = new File(static_dir,path);
            String line;
            if (file.isFile()){ // 如果是文件，说明访问的资源存在
                // 发送状态行
                line = "HTTP/1.1 200 OK";
            }
            else{
                line = "HTTP/1.1 404 NotFound";
                // 如果不存在则访问404页面
                file = new File(static_dir,"/root/404.html");
            }
            printLine(line);
            // 发送响应头
            line = "Content-Type: text/html";
            printLine(line);
            line = "Content-Length: " + file.length();
            printLine(line);
            // 单独的回车+换行
            printLine("");
            // 发送响应正文
            OutputStream out = socket.getOutputStream();
            byte[] content = new byte[1024*10];
            int len;
            // 创建输入流读取 index.html
            FileInputStream fis = new FileInputStream(file);
            while ((len=fis.read(content))!=-1){
                out.write(content,0,len);
            }
            System.out.println("All content has been send");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                //
                socket.close();
            } catch (Exception e){
                e.printStackTrace();
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

}
