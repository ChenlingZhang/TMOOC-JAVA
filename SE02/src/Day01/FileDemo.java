package Day01;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        // 访问文件需要家后缀
        File file = new File("./Demo.txt");

        // 获取文件名字
        String fileName = file.getName();
        System.out.println(fileName);

        // 获取当前文件的长度（字节）
        long length = file.length();
        System.out.println(length);

        // 获取当前文件是否可写
        boolean canWrite = file.canWrite();
        System.out.println("文件是否可写: " + canWrite);

        // 获取当前文件是否可读
        boolean canRead = file.canRead();
        System.out.println("文件是否可读: " + canRead);

        // 当前文件是否隐藏
        boolean isHidden = file.isHidden();
        System.out.println("文件是否隐藏: " + isHidden);

        // 当前file对象是否是文件
        boolean isFile = file.isFile();
        System.out.println("文件是否是文件: " + isFile);

        // 可以获取当前文件不存在的状态
        boolean isExists = file.exists();
        System.out.println("文件是否存在: " + isExists);

        // 获取当前文件所在的父级路径
        String parentPath = file.getParent();
        System.out.println(parentPath);

        // 获取当前文件的绝对路径
        String fileAbsolutePath = file.getAbsolutePath();
        System.out.println(fileAbsolutePath);


    }


}
