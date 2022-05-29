package Part04Socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 聊天室的客户端
 */
public class Client {
    /*
     * java.net.Socket 套接字,原意是插座
     * Socket中封装了TCP协议的通信细节,我们使用他可以与远端计算机建立TCP链接,
     * 并且基于一堆流的IO操作,完成与远端计算机的数据交换
     */
    private Socket socket;
    /*
     * 初始化客户端
     */
    public Client(){
        try {
            System.out.println("正在链接服务器端...");
            /*
             * 实例化Socket时需要传入两个参数:
             * 参数1: 远端计算机的地址信息 ip localhost 127.0.0.1
             * 参数2: 远端计算机的服务器端口
             * 上述构造器实例化的过程就是与远端计算机建立链接的过程,如果成功建立链接则实例化成功,
             * 否则构造器就会抛出异常
             */
            socket = new Socket("localhost",8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * 客户端开始工作的方法
     */
    public void start(){
        try {
            /*
             * 通过Socket的方法:
             * OutputStream getOutputStream()
             * 获取的字节输出流,通过这个流对象可以将写出的字节通过网络发送给远端建立好链接的计算机.
             */
            SeverHandle handle = new SeverHandle();
            Thread t = new Thread(handle);
            t.setDaemon(true); // 将severhandle设置为守护线程
            t.start();
            OutputStream out = socket.getOutputStream();
            //创建一个转换流,链接字节流和字符流
            OutputStreamWriter osw =
                    new OutputStreamWriter(
                            out, StandardCharsets.UTF_8);
            //创建一个缓冲字符流
            BufferedWriter bw = new BufferedWriter(osw);
            //创建一个高级字符流,开启自动行刷新
            PrintWriter pw = new PrintWriter(bw,true);

            Scanner scanner = new Scanner(System.in);
            //一直接收客户端向服务器发送的每行内容
            while (true){
                String line = scanner.nextLine();
                //当客户端输入exit时,就退出,忽略大小写
                if ("exit".equalsIgnoreCase(line)){
                    break;//跳出循环
                }
                //将客户端写入的字符串发送给服务器
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                socket.close();//与远端计算机断开连接,进行TCP挥手
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    // 该线程专门用于读取服务器端发送过来的消息
    private class SeverHandle implements Runnable{

        @Override
        public void run() {
            try {
                InputStream ins = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(ins, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while((line = br.readLine())!=null){
                    System.out.println(line);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
