package Part2_IO;

import java.io.*;
import java.util.Scanner;

/**
 * 在流链接中使用pw
 */
public class PWDemo02 {
    public static void main(String[] args) throws IOException {
        // 文件字节输出流，向文件中写入字节数据
        FileOutputStream fos = new FileOutputStream("./pw2.txt", true);
        // 转换输出流， 1. 衔接字符与字节流 2. 将写出的字符转换成字节
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        // 缓冲字符输出流，快滴血加快效率
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter writer = new PrintWriter(bw,true);
        Scanner in = new Scanner(System.in);
        boolean isContinue = true;
        while (isContinue){
            System.out.println("Please Enter content, enter exit to close: ");
            String content = in.nextLine();
            if (content.equalsIgnoreCase("exit")){
                isContinue = false;
            }
            else {
                writer.println(content);
            }

        }
        writer.close();
    }
}
