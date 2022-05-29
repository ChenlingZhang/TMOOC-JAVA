package com.webserver.core;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServerApplication {
    private ServerSocket serverSocket;
    public WebServerApplication(){
        try{
            System.out.println("Starting Server");
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is ready");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void start(){
        try {
            System.out.println("Waiting client connect...");
            Socket socket = serverSocket.accept();
            System.out.println("one client connected");
            ClientHandle handle = new ClientHandle(socket);
            Thread t = new Thread(handle);
            t.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        WebServerApplication server = new WebServerApplication();
        server.start();
    }
}
