package cn.tedu.OOPCase.Day02;

public class Student extends Person{
    int studentID;
    public Student(String name, int age, String sex, int studentID){
        super(name,age,sex);
        this.studentID = studentID;
    }
    public void eat(){
        System.out.println(name + " is eating");
    }
    public void sleep(){
        System.out.println(name + " is sleeping");
    }
    public void study(){
        System.out.println(name +" is studying student id is: " + studentID);
    }
}
