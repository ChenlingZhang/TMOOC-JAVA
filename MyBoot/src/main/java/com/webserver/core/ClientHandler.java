package com.webserver.core;

//crtl+alt+o 快速去除无用的包

import com.webserver.http.EmptyRequestException;
import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;

import java.io.IOException;
import java.net.Socket;

/**
 * 该线程任务类,负责与指定的客户端完成HTTP交互
 * 每次HTTP交互都采取一问一答的规则,因此交互由三步完成:
 * 1:解析请求
 * 2:处理请求
 * 3:发送响应
 */
public class ClientHandler implements Runnable{
    private Socket socket;
    public ClientHandler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //1解析请求
            HttpServletRequest request = new HttpServletRequest(socket);
            HttpServletResponse response = new HttpServletResponse(socket);
            //2处理请求
            DispatcherServlet servlet = new DispatcherServlet();
            servlet.service(request, response);
            //3发送响应
            response.response();
            System.out.println("响应发送完毕!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EmptyRequestException e) {

        } finally {
            try {
                //一次HTTP协议交互后,断开连接(HTTP协议要求的)
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
