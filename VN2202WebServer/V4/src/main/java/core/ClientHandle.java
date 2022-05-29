package core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

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
            String line = readLine();
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
            // 解析消息头
            //存储消息头的信息，key为消息头的名字 value为消息头的值
            Map<String,String> header = new HashMap<>();
            while(true){
                line = readLine();
                if (line.isEmpty()){
                    // 判断是否获取到连续的回车+空字符串
                    break;
                }
                // 将消息头的名字和值进行拆分，需要使用正则表达式+空格进行拆分
                data = line.split(":\\s");
                header.put(data[0],data[1]);
            }
            header.forEach(
                    (k,v)-> System.out.println("消息头: " + k + " 内容: " + v)
            );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private String readLine() throws IOException {
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
        return builder.toString().trim();
    }
}
