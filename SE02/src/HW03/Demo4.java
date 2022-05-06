package HW03;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("./note.txt",true);
        boolean isContinue = true;
        Scanner in = new Scanner(System.in);
        while(isContinue){
            System.out.println("请输入要记录的内容");
            String note = in.nextLine();
            fos.write(note.getBytes(StandardCharsets.UTF_8));
            if (note.equalsIgnoreCase("exit")){
                isContinue = false;
            }
        }

    }
}
