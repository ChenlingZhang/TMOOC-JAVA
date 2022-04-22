package Day01;

import java.io.File;

/**
 * 获取文件夹下的所有子项
 */
public class ListFileDemo {
    public static void main(String[] args) {
        File dir = new File("."); // 一个文件夹路径对象
        if (dir.isDirectory()){
            File[] files = dir.listFiles();
            System.out.println(files.length);
            for (File f:files) {
                System.out.println(f.getName());
            }
        }
    }
}
