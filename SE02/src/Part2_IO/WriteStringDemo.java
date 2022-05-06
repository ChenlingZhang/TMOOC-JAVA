package Part2_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteStringDemo  {
    public static void main(String[] args) throws IOException {
        // 像一个文件名为demo01.txt的文件名中写入数据
        FileOutputStream fos = new FileOutputStream("./demo01.txt");
        String line = "beep, beep, I'm a sheep";
        /**
         * String 提供了将字符串转换为一组字节的写法
         * 使用的字符集通常都是UTF-8
         * import java.nio.charset.StandardCharsets 下的 UTF_8;
         */
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);
        fos.write(" bee, bee, I'm a sheep".getBytes(StandardCharsets.UTF_8));
        fos.close();
    }
}
