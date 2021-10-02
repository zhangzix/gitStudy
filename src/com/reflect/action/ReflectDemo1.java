package com.reflect.action;

import com.reflect.moudle.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射获取类
 * ？ 表示不确定的java类型。
 * T 表示java类型。
 * K V 分别代表java键值中的Key Value。
 * E 代表Element。
 */

public class ReflectDemo1 {


/**
 * 获取反射对象(反射入口): Class  的三种方式
 */
    /**
     * 三种获取反射对象  (反射入口) 的方式 ( Class )
     * 1.Class.forName();
     * 2.类名.class
     * 3.对象.getClass()
     */
    public static void getReflectEntrance() throws ClassNotFoundException {
        //        1.Class.forName();
        Class<?> aClass = Class.forName("com.reflect.moudle.Person");
        System.out.println(aClass);
//        2.类名.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
//        3.对象.getClass()
        Person person=new Person();
        Class<? extends Person> perClass = person.getClass();
        System.out.println(perClass);
    }

    /**
     * 通过反射获取方法
     * 1.getMethods():获取本类以及父类、接口中的所有public方法
     * 2.getDeclaredMethods():获取本类中的所有方法
     */
    public static void getMethodsByClass(){
        Class<?> aClass=null;
        try {
             aClass = Class.forName("com.reflect.moudle.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int num=0;

        //获取所有的公共的方法 （ 1.本类以及父类、接口中的所有public方法 ）
        System.out.println("getMethods()获取所有的公共方法");
        Method[] methods = aClass.getMethods();
        for (Method method:methods){
            num++;
            System.out.print(num+" : ");
            System.out.println(method);
        }
        System.out.println("--------------------");
        System.out.println("getDeclaredMethods()获取本类的所有方法");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method:declaredMethods){
            System.out.println(method);
        }


    }

    /**
     * 通过反射入口对象 获取所有接口是一个数组  多实现
     * 和一个父类   单继承
     * 和所有的构造器 一个数组
     */
    public static void getInterfaceByClass(){
        Class<?> perClass=null;
        try {
            perClass = Class.forName("com.reflect.moudle.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取所有接口
        System.out.println("通过反射获取所有接口");
        Class<?>[] interfaces = perClass.getInterfaces();
        for (Class<?> face:interfaces){
            System.out.println(face);
        }
        System.out.println("----------------------");
        System.out.println("通过反射获取父类");
        Class<?> superclass = perClass.getSuperclass();
        System.out.println(superclass);
        System.out.println("----------------------");
        System.out.println("通过反射获取所有构造方法");
        Constructor<?>[] constructors = perClass.getConstructors();
        for (Constructor<?> constructor:constructors){
            System.out.println(constructor);
        }
    }

    /**
     * 通过反射获取公共属性
     */
    public static void getFilesByClass(){
        Class<?> perClass=null;
        try {
            perClass = Class.forName("com.reflect.moudle.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("getFields():获取公共属性");
        Field[] fields = perClass.getFields();
        for (Field field :fields){
            System.out.println(field);
        }
        System.out.println("--------------");
        System.out.println("获取本类的所有属性");
        Field[] declaredFields = perClass.getDeclaredFields();
        for (Field field:declaredFields){
            System.out.println(field);
        }

    }
    public static void main(String[] args) throws ClassNotFoundException {
//      获取反射入口
//        getReflectEntrance();
        /*
            1.通过反射获取所有的公共方法
            2.通过反射获取本类的所有方法包括private
         */
//        getMethodsByClass();
        //通过反射 获取所有接口和父类 和 所有构造器
//        getInterfaceByClass();
       /*
         1.通过反射获取所有的公共属性(父类，接口，本类)
         2.通过反射获取 当前类的所有属性(只有当前类)
         */
      getFilesByClass();

    }



}
