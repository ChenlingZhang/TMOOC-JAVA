package Part2_IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象流
 * java.io.ObjectOutputstream
 * java.io.ObjectInputStream
 * 对象流是一对高级流，在流连接中完成对对象的字节转换，即对象序列化与反序列化
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        String name = "Jerry";
        int age = 18;
        String gender = "男";
        String[] otherInfo = {"come from some unknow place", "Germini"};
        Person p = new Person(name,age,gender,otherInfo);
        System.out.println(p.toString());
        // 创建对象流
        FileOutputStream fos = new FileOutputStream("./person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);
        oos.flush();
        oos.close();

    }
}
