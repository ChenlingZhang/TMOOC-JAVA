package Part08_reflect;

import Part08_reflect.annotation.AutoRunClass;

import java.io.File;
import java.net.URISyntaxException;

public class Test03 {
    public static void main(String[] args) throws Exception {
        File dir = new File(Test03.class.getResource(".").toURI());
        File[] subs = dir.listFiles(f->f.getName().endsWith(".class"));
        for (File sub : subs) {
            String filename = sub.getName();
            String className = filename.substring(0,filename.indexOf("."));
            Class cls = Class.forName(Test03.class.getPackage().getName()+"."+className);
            if (cls.isAnnotationPresent(AutoRunClass.class)){
                System.out.println(cls.getName()+"被@AutoRunClass标注了");
            }
            else{
                System.out.println(cls.getName()+"没有被@AutoRunClass标注了");
            }
        }
    }
}
