package Part2_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 通过块读写来提高文件拷贝的速度
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./view.jpeg");
        FileOutputStream fos = new FileOutputStream("./view4.jpeg");
        byte[] data = new byte[1024*10];
        long startTime = System.currentTimeMillis();
        int len;
        while((len=fis.read(data))!= -1){
            fos.write(data,0, len);
        }
        fis.close();
        fis.close();
        long endTime = System.currentTimeMillis();
        System.out.println("完成时间: " + (endTime-startTime));
    }
}
