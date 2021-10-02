package com.reflect.moudle;

import com.reflect.Interface.MyInterface;

public class Person extends Super implements MyInterface{
    private Integer id;
    private String username;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Person(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public static void staticMethod(){
        System.out.println("StaticMethod");
    }
    private void myPrivateMethod(){
        System.out.println("这是Person私有的方法");
    }
    private void myPrivateMethod2(String name){
        System.out.println("这是Person私有的方法"+name);
    }
    @Override
    public void say() {
        System.out.println("MyInterface   sat method");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Person再吃");
    }
}
