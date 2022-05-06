package Part1_Lambda;

import java.io.File;

/**
 * 创建文件夹的使用演示类
 */
public class CreateDirectoryDemo {
    public static void main(String[] args) {
        File dir = new File("./Test_dir");
        File mutiDir = new File("./multi/A/B/C");
        if (!dir.exists()){
            boolean isCreated = dir.mkdir(); //创建单个目录
            // mkdirs 创建多个目录
            System.out.println("路径是否创建成功: "+ isCreated);
        }
        if (!mutiDir.exists()){
           boolean isCreated =  mutiDir.mkdirs();
            System.out.println("多路径是否创建成功: " + isCreated);
        }else{
            System.out.println("finish");
        }
    }
}
