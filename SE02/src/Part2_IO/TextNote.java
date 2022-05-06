package Part2_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 实现简易的记事本工具， 程序启动后，要求在控制台输入的每一行字符串都会写入到note.txt
 * 当我们在控制台输出exit时，程序推出
 */
public class TextNote {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("./note.txt",true);
        Scanner userInput = new Scanner(System.in);
        String line;
        boolean isContinue = true;
        while(isContinue){
            System.out.println("Please Enter your note, enter 'exit' to quite ~");
            line = userInput.nextLine();
            if (line.equals("exit")){
                isContinue = false;
            }
            else{
                fos.write(line.getBytes(StandardCharsets.UTF_8));
                System.out.println("Writting finish");
            }
        }
        fos.close();

    }
}
