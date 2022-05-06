package Part1_Lambda;

import java.io.File;

/**
 * 这个类用于测试删除文件
 */
public class DeleteFileDemo {
    public static void main(String[] args) {
        File dir = new File("./Test_dir");
        if (dir.exists()){
            boolean isDelete = dir.delete(); // 只可以删除控的文件夹
            System.out.println("文件夹是否删除：" + isDelete);
        }
        else{
            System.out.println("文件不存在" );
        }

        // 删除文件
        File file = new File("./Demo.txt");
        if (file.exists()){
            boolean isFileDelete = file.delete();
            System.out.println("文件是否删除: " + isFileDelete);
        }
        else{
            System.out.println("文件已删除！");
        }
    }
}
