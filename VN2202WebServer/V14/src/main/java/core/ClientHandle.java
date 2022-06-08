package core;

import http.HTTPServletRequest;
import http.HttpServletResponse;
import java.net.Socket;

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
            DispatcherServlet servlet = new DispatcherServlet();
            servlet.service(request,response);
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
