package cn.tedu.OOPCase.Day02;

public class Teacher extends Person {
    int salary;
    public Teacher(String name, int age, String sex, int salary){
        super(name,age,sex);
        this.salary = salary;
    }

    public void getPay(){
        System.out.println(name +" 's salary is : " + salary);
    }
}
