package Part4_Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 聊天室的服务器
 */
public class Server {
    /**
     * Java.net.ServerSocket
     * ServerSocket是运行在服务器端，他的主要工作是：
     * 1：打开服务器端口（客户端就是通过这个端口与服务器建立链接）
     * 2：监听服务器端口，一旦有一个客户端访问，则会放回一个Socket实例，并通过Socket对象与对应的来访客户端进行交互
     */
    private ServerSocket serverSocket;
    private Collection<PrintWriter> allOut = new ArrayList<>();
    public Server(){
        System.out.println("正在启动服务器端...");
        try {
            serverSocket = new ServerSocket(8088);
            System.out.println("服务器启动完毕！！");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void start(){
        while(true){
            System.out.println("等待客户端链接...");
            /**
             * Socket accept()该方法是一个阻塞方法，调用后开始等待，知道一个客户端来访问时，该方法会给这个客户端返回一个Socket
             * 通过Socket对象与该客户端进行交互，程序继续详细进行
             */
            try {
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端链接了！");
                InputStream in = socket.getInputStream();
                InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(reader);
                String line;
                while((line = br.readLine()) != null){
                    System.out.println("Message From Client: " + line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args){
        Server server = new Server();
        server.start();
    }
}
