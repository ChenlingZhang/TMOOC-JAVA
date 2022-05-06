package Part2_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Java IO 将流按照读写的单位划分为字节流和字符流
 * java.io.InputOutStream 和 OutputStream 是所有字节输入和输出的超类，最小单位是字节
 * 而 java.io.Reader 和 Writer是所有字符输入和输出的超类，最小单位是字符
 * 因此注意：
 *  -只适合读取文本数据
 *  -字符流的本质还是读写字节只是自动完成了字符和字节的转换
 * java.io.InputStreamReader 和 OutputStreamWriter
 * 这对流是一对高级流，作用有两个：
 * 1. 在流链接时，衔接其他高级字符流和下面的字节流
 * 2. 负责将字符与对应的字节按照指定的字符集自动转换方便读写操作
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        // 向文件osw.txt 文件中写入文本数据
        // 文件字节输出流
        FileOutputStream fos = new FileOutputStream("./osw.txt");
        OutputStreamWriter writer = new OutputStreamWriter(fos);
        String text = "lalalala";
        writer.write(text);
        writer.flush();
        writer.close();
    }
}
