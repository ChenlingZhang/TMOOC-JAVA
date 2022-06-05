package com.webserver.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerApplication {
    private ServerSocket serverSocket;

    public WebServerApplication() {
        try{
            System.out.println("Server Starting...");
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is ready");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start(){
        System.out.println("Waiting for client connect ... ");
        try {
            Socket socket = serverSocket.accept();
            System.out.println("There has one client connected");
            ClientHandle handle = new ClientHandle(socket);
            Thread thread = new Thread(handle);
            thread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebServerApplication webServerApplication = new WebServerApplication();
        webServerApplication.start();
    }
}
