package Part2_IO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw = new PrintWriter("./pw.txt","UTF-8");
        pw.println("一壶清茶一包烟，一行代码想一天");
        pw.println("这是第二行");
        pw.close();
    }
}
