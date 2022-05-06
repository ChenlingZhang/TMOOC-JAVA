package Part2_IO;

import java.io.FileOutputStream;

/**
 * 文件输出流演示类
 */
public class FileOutPutStreamDemo {
    public static void main(String[] args) {
        /**
         * 文件输出流：通过程序写出到磁盘某个位置
         */
        String pathName = "./fos.dat";
        fileOutPutStream(pathName);
    }

    public static void fileOutPutStream(String pathName){
        try {
            FileOutputStream fos = new FileOutputStream(pathName);
            fos.write(1); // 写入int的数据
            fos.write(2);
            fos.close(); // 关闭流体
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
