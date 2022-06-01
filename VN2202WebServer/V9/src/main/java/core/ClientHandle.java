package core;

import http.HTTPServletRequest;
import http.HttpServletResponse;

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
            // 响应请求
            HttpServletResponse response = new HttpServletResponse(socket);
            // 处理请求
            String path = request.getUrl();
            System.out.println("Abstract Path: " + path);

            File static_dir = new File(ClientHandle.class.getClassLoader().getResource("./static").toURI());
            /*
            指定父级目录，防止子级目录报错，影响父级目录。报空指针错误
             */
            File file = new File(static_dir,path);
            String line;
            if (file.isFile()){ // 如果是文件，说明访问的资源存在
                // 发送状态行
                response.setContentFile(file);

            }
            else{
                response.setStatusCode(404);
                response.setStatusResult("NotFound");
                // 如果不存在则访问404页面
                file = new File(static_dir,"/root/404.html");
                response.setContentFile(file);

            }
            // 发送响应

            response.response();

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



}
