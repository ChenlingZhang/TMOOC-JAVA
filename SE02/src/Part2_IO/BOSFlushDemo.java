package Part2_IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 缓冲流写出数据的缓冲区问题
 */
public class BOSFlushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("./bos.txt");
        // 缓冲流内部维护了一个8K的字节数组，写出的数据都会先存入到数组中，只有数组寸满时才会写出。
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("Fulush Out Put".getBytes(StandardCharsets.UTF_8));
        // flush 冲水 方法的最用是让缓冲输出流将其中的缓冲区中已经缓存的数据立即写出
        bos.flush();
        //bos.close();
    }
}
