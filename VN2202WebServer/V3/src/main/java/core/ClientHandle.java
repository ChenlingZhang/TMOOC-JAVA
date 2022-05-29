package core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 该线程任务类，负责与指定的客户端完成HTTP
 */
public class ClientHandle implements Runnable {
    private Socket socket;
    public ClientHandle(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            InputStream in = socket.getInputStream();
            StringBuilder builder = new StringBuilder();
            int d;
                char pre ='a', cur='b';
            while ((d = in.read())!=-1){
                cur = (char) d;
                if (pre == 13 && cur==10){
                    break;
                }
                builder.append(cur);
                pre = cur;
            }
            String line = builder.toString();
            System.out.println("第一行 " + line);
            //请求行相关的信息
            String method; // 请求方式
            String url; // 抽象路径
            String protocol; // 协议版本
            // 使用正则表达式通过空格<\\s>进行拆分
            String[] data = line.split("\\s");
            method = data[0];
            url = data[1];
            protocol = data[2];
            System.out.println("method: " + method + "\n" + "url: " + url + "\n" + "protocol: " + protocol + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
