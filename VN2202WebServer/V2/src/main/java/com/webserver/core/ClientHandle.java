package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandle implements Runnable {
    private Socket socket;
    public ClientHandle(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            int d;
            while ((d = in.read())!=-1){
                System.out.print((char) d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
