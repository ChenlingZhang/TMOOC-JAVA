package cn.tedu.OOPCase.Day01;

public class Student {
    int age;
    String name;
    int studentID;
    public Student(int age, String name, int studentID){
        this.age = age;
        this.name = name;
        this.studentID = studentID;
    }
    public void study(){
        System.out.println(name + " 正在刻苦练习");
    }
    public void sayHi(){
        System.out.println("大家好，我叫 " + name +" 今年 "+ age + " 岁了，我的学号是 " + studentID);
    }
}
