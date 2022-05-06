package Part1_Lambda;

import java.io.File;
import java.io.FileFilter;

/**
 * 文件过滤器，可以有条件的进行筛选要获取的文件内容
 */
public class LIstFileDemo2 {
    public static void main(String[] args) {
        File file = new File(".");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().contains("o");
            }
        };
        File[] files = file.listFiles();
        System.out.println("过滤前长度: " + files.length);
        for (File f : files) {
            System.out.print("循环输出: " + f.getName());
        }
        System.out.println(" ");

        File[] filterFiles = file.listFiles(fileFilter);
        System.out.println("过滤后长度: " + filterFiles.length);
        for (File f: filterFiles) {
            System.out.print("循环输出: " + f.getName());
        }
    }
}
