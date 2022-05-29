package Part4_Socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *  聊天室的客户端
 */
public class Client {
    /**
     * 初始化客户端
     */
    private Socket socket;

    public Client(){
        System.out.println("正在链接服务器端...");
        try {
            socket = new Socket("localhost",8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Start Client
     */
    public void start(){
        try {
            /**
             * 通过Socket方法：
             * OutputStream getoutputstream()
             * 获取字节输出流，通过这个流对象可以将写出的字节通过网络发送给远端建立好的计算机
             */
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            PrintWriter pw = new PrintWriter(outputStreamWriter, true);
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Enter Comments: ");
                String line = scanner.nextLine();
                if ("exit".equalsIgnoreCase(line)){
                    break;

                }
                pw.println(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
       Client client =  new Client();
       client.start();
    }
}
