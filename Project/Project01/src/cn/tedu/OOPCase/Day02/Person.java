package cn.tedu.OOPCase.Day02;

public class Person {
    String name;
    int age;
    String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public void sayHi() {
        System.out.println("Hello My name is: " + name + " my age is: " + age);
    }

    }

