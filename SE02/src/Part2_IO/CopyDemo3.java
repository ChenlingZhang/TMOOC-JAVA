package Part2_IO;

import java.io.*;

/**
 * 使用缓冲流实现复制文件案例
 */
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        // 创建字节文件输出流
        FileInputStream fis = new FileInputStream("./view.jpeg");
        // 创建一个缓冲字节流
        BufferedInputStream bis = new BufferedInputStream(fis);
        // 创建字节文件输入流
        FileOutputStream fos = new FileOutputStream("./view4.jpeg");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        long startTime = System.currentTimeMillis();
        int d;
        while((d= bis.read()) != -1){
            bos.write(d);
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("用时: " + (finishTime-startTime));
        bis.close();
        bos.close();
    }
}
