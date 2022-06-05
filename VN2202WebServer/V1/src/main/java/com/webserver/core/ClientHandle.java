package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandle implements Runnable{
    private Socket socket;

    public ClientHandle(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            StringBuilder  builder = new StringBuilder();
            char rear = ' ', front=' ';
            int d;
            while ((d=inputStream.read())!=-1){
                front = (char)d;
                if (rear == 13 && front ==10){
                    break;
                }
                builder.append(front);
                rear = front;
            }
            // 解析请求头
            String header = builder.toString();
            String[] splitString = header.split("\\s");
            String method = splitString[0];
            String url = splitString[1];
            String protocol = splitString[2];
            System.out.println("Method: " + method + " " + "url: " + url + " " + "protocol: " + protocol);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
