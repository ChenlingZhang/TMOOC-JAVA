package Part1_Lambda;

import java.io.File;
import java.io.FileFilter;

public class LambdaDemo {
    public static void main(String[] args) {
        File file = new File(".");
        // 可以忽略 New Filter（接口名） 和内部重写的方法名
        FileFilter fileFilter = (File filePath)->{
            return filePath.getName().contains("o");
        };

        // 当内部方法的形式参数只有一个的话 则参数类型可以忽略，小括号也可以省略
        FileFilter fileFilter1 = fileName-> {
            return fileName.getName().contains("o");
        };

        // 若内部重写的方法，方法题只有一行代码的话{}可以不屑 return 也可以不写
        FileFilter fileFilter2 = fileName->fileName.getName().contains("o");

        File[] filterFiles = file.listFiles(fileFilter2);
        System.out.println("过滤后长度: " + filterFiles.length);
        for (File f: filterFiles) {
            System.out.print("循环输出: " + f.getName());
        }
    }
}
