package Part08_reflect;

import Part08_reflect.annotation.AutoRunClass;
import Part08_reflect.annotation.AutoRunMethod;

@AutoRunClass
public class Person {
    private String name = "zzz";
    private int age = 18;

    public Person(){}

    public Person(String name, int age) {
            this.name = name;
        this.age = age;
    }

    @AutoRunMethod(3)
    public void sayHello(){
        System.out.println(name+":"+"hello!");
    }
    @AutoRunMethod(3)
    public void sayGoodBye(){
        System.out.println(name+":"+"goodbye!");
    }
    @AutoRunMethod(3)
    public void sayHi(){
        System.out.println(name+":"+"hi!");
    }
    public void doSome(String thing){
        System.out.println(name+"正在"+thing);
    }
    public void doSome(String thing,int sum){
        for (int i = 0; i < sum; i++) {
            System.out.println(name+"正在"+thing);
        }
    }
    private void secret(){//secret 秘密
        System.out.println(name+":这是我的私有方法!");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
