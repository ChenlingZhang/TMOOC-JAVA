package Part2_IO;

import java.io.FileInputStream;

public class FileInputStreamDemo {

    public static void main(String[] args) {
        String pathName = "./fos.dat";
        FileInput(pathName);
    }

    public static void FileInput(String pathName){
        try{
            FileInputStream fis = new FileInputStream(pathName);
            int d = fis.read();
            System.out.println(d);
            d = fis.read();
            System.out.println(d);
            fis.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
