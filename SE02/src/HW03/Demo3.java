package HW03;

import java.io.*;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./view.jpeg");
        FileOutputStream fos = new FileOutputStream("./view5.jpeg");
        byte[] data = new byte[1024*10];
        while(fis.read(data) !=-1){
            fos.write(data);
        }
    }
}
