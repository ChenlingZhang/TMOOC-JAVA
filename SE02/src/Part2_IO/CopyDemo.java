package Part2_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制Demo
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./view.jpeg");
        FileOutputStream fileOutPutStream = new FileOutputStream("./view2.jpeg");
        int d = 0;
        while((d=fileInputStream.read())!= -1){
            fileOutPutStream.write(d);
        }
        fileInputStream.close();
        fileOutPutStream.close();
    }
}
