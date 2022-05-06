package Part1_Lambda;

import java.io.File;

/**
 * 创建文件或文件夹的使用演示类
 */
public class CreateFileDemo {
    public static void main(String[] args) {
        // 当前项目路径下创建一个文件
        File file = new File("./Demo2.txt"); // 创建一个文件路径对象
        // 判断当前文件路径下不存在同名文件
        if (!file.exists()) {
            try {
                boolean isSuccess = file.createNewFile();
                System.out.println("文件是否创建成功: " + isSuccess);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已经存在");
        }
    }
}
