package Part2_IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OISDEMO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./person.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        /**
         * 反序列过程，返回一个object类型
         */
        Person p = (Person) ois.readObject();
        String result = p.toString();
        System.out.println(result);
        ois.close();
    }
}
