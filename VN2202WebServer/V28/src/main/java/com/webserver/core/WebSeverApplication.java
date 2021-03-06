package com.webserver.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * WebServer主类:
 * WebServer是一个web容器,模拟tomcat服务器的基本功能.
 * Web容器有两个主要任务:
 * 1:管理部署在容器中的所有的网络应用(webapp),每个网络应用就是我们俗称的网站,
 * 它通常包含页面,处理业务的代码和其他资源等等
 * 2:负责与客户端(通常是浏览器)完成TCP链接,并基于HTTP协议进行交互,使得客户端
 * 可以通过网络远程调用容器中的某个网络应用
 */
public class WebSeverApplication {
    private ServerSocket serverSocket;
    private ExecutorService threadpool;
    public WebSeverApplication(){
        try {
            System.out.println("正在启动服务器...");
            serverSocket = new ServerSocket(8088);
            threadpool = Executors.newFixedThreadPool(50);
            System.out.println("服务器启动完毕!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            while (true){
                System.out.println("等待客户端链接...");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端链接了!!!");
                //启动一个线程,负责与该客户端交互
                ClientHandler handler = new ClientHandler(socket);
                //Thread t = new Thread(handler);
                // t.start();
                threadpool.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        WebSeverApplication server = new WebSeverApplication();
        server.start();
    }
}
