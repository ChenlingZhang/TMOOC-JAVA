package Part04Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 聊天室的服务器
 */
public class Server {
    /*
     * java.net.ServerSocket
     * ServerSocket是运行在服务器端,它的主要工作是:
     * 1:打开服务器端口(客户端就是通过这个端口与服务器建立链接)
     * 2:监听该服务器端口,一旦有一个客户端访问,则会返回一个Socket实例,并通过这个
     * Socket对象与对应的来访客户端进行交互
     * 可以将Socket比喻为手机 ServerSocket比喻为总机
     */
    private ServerSocket server;
    //private PrintWriter[] allOut= {}; //该数组用于存放所有的客户端的输出流，用于广播消息给所有的客户端
    private Collection<PrintWriter> allOut = new ArrayList<>();
    public Server() {
        try {
            System.out.println("正在启动服务器端...");
            /*
             * 实例化ServerSocket的同时,需要指定打开的端口号,此端口一定要和客户端访问的
             * 端口号一致,否则一定会访问失败!
             * java.net.BindException:address already in use
             * 表示端口号被占用了,更换一个端口
             */
            server = new ServerSocket(8088);
            System.out.println("服务器启动完毕!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (true) {
                System.out.println("等待客户端链接...");
                /*
                 * ServerSocket中提供的方法:
                 * Socket accept()
                 * 该方法是一个阻塞方法,调用后开始等待,直到一个客户端来访问时,
                 * 该方法会给这个客户端返回一个Socket,通过这个Socket对象与
                 * 该客户端进行交互,程序继续向下进行
                 */
                Socket socket = server.accept();
                System.out.println("一个客户端链接了!");
                //启动一个线程来处理与该客户端的交互
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
    /*
     * 该线程任务类主要负责与特定的客户端交互
     */
    private class ClientHandler implements Runnable{
        private Socket socket;
        public ClientHandler(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            PrintWriter pw = null;
            try {
                /*
                 * 通过Socket提供的getInputStream方法
                 * 可以获取一个字节输入流,读取来自远端计算机发送过来的字节数据
                 */
                InputStream in = socket.getInputStream();
                //创建一个转换流
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                //创建缓冲读取字符流,按行读取字符串
                BufferedReader br = new BufferedReader(isr);
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out);
                BufferedWriter bw = new BufferedWriter(osw);
                pw = new PrintWriter(bw,true);
                //将客户端的输出流存入共享的数组中
                // 1. 对allOut扩容,每次增加1个长度
                allOut.add(pw);
                sendMessage("欢迎一个客户端上线了，当前在线人数: " + allOut.size());
                //循环接收客户端发送过来的字符串
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("客户端说:" + line);
                    // 将消息回给所有的客户端
                    for (PrintWriter p: allOut) {
                        p.println("客户端说: " + line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                /*for (int i = 0; i< allOut.length;i++){
                    if (allOut[i] == pw) {
                        allOut[i] = allOut[allOut.length - 1];
                        synchronized (Server.this) {
                            allOut = Arrays.copyOf(allOut, allOut.length - 1);
                        }
                    }*/
                allOut.remove(pw);
                }
                try {
                    // 服务器端关闭socket
                    socket.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        /**
         * 广播消息给所有客户端
         * @param message
         */
        public void sendMessage(String message) {
            synchronized (Server.this) {
            /*for (int i = 0; i < allOut.length; i++) {
                allOut[i].println(message);
            }*/
                for (PrintWriter pw: allOut) {
                    pw.println(message);
                }
            }
        }
}
