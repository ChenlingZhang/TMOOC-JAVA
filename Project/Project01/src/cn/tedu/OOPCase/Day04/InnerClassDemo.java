package cn.tedu.OOPCase.Day04;

/**
 * This class used to test 匿名内部类
 */
public class InnerClassDemo {
    public static void main(String[] args) {
        // 创建匿名内部类
        Aoo a = new Aoo(){
            public void show(){
                // 匿名内部类使用外部累属性会默认为final属性
                System.out.println("匿名内部类重写Aoo的方法");
                // 匿名内部类有自己的.class字节码文件，通过$+标号来表示（InnerClassDemo$1.class)
            }
        };
        a.show();
        
    }
}

class Aoo{
    public void show(){
        System.out.println("Aoo 这个父类的show方法");
    }
}