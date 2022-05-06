package Part2_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ISRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./osw.txt");
        InputStreamReader reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
        // 读取一个字符，返回一个int值是一个char
        int d;
        while((d = reader.read()) != -1){
            System.out.print((char) d);
        }
        reader.close();
    }
}
