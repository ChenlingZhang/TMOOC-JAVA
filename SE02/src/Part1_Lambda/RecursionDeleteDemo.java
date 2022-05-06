package Part1_Lambda;

import java.io.File;

public class RecursionDeleteDemo {
    public static void main(String[] args) {
        File file = new File("./multi");
        deleteDir(file);
    }

    public static void deleteDir(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File f: files) {
                deleteDir(f);
            }
        }
        file.delete();
    }
}
