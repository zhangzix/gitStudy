package com.reflect.action;

import com.reflect.moudle.Person;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReflectDemo2 {

    /**
     * 通过反射获取对象实例，并操作对象  newInstance()
     */
    public static void demo1() throws IllegalAccessException, InstantiationException {
        Class<?> perClass=null;
        try {
            perClass = Class.forName("com.reflect.moudle.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person person = (Person) perClass.newInstance();
        person.setUsername("zzx");
        person.setId(45);
        System.out.println(person.toString());
    }

    /**
     * 通过反射操作对象私有属性和方法，并修改访问权限 setAccessible(true)
     * 如果因为 访问修饰符限制造成异常 可以通过setAccessible(true)暂时解决
     * 通过反射调用方法使用invoke()
     */
    public static void demo2() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> perClass=null;
        try {
            perClass = Class.forName("com.reflect.moudle.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person person = (Person) perClass.newInstance();

        Field id = perClass.getDeclaredField("id");
        /*
            必须要修改属性访问权限 不然不能修改
         */
        id.setAccessible(true);
        id.set(person,45);
        System.out.println(person.getId());
        System.out.println("--------------");
        System.out.println("这是对象的无参私有方法");
        Method myPrivateMethod = perClass.getDeclaredMethod("myPrivateMethod", null);
        myPrivateMethod.setAccessible(true);
        myPrivateMethod.invoke(person, null);
        System.out.println("--------------");
        System.out.println("这是对象的有参私有方法");
        Method myPrivateMethod2 = perClass.getDeclaredMethod("myPrivateMethod2", String.class);
        myPrivateMethod2.setAccessible(true);
        myPrivateMethod2.invoke(person,"zzx");

    }

    /**
     * 通过反射动态调用方法
     */
    public static void demo3() throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Properties properties=new Properties();


        properties.load(new FileReader("class.txt"));
        String classname = properties.getProperty("classname");
        String methodname = properties.getProperty("methodname");
        Class<?> perClass=null;
        try {
            perClass = Class.forName(classname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method method = perClass.getDeclaredMethod(methodname);
        method.invoke(perClass.newInstance());

    }

    /**
     * 通过反射越过泛型检查
     */
    public static void demo4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> my_list=new ArrayList<>();
        my_list.add(1);
        my_list.add(13);
        my_list.add(12);

        Class<?> list_Class = my_list.getClass();
        Method add = list_Class.getMethod("add", Object.class);
        add.invoke(my_list,"厉害了");
        System.out.println(my_list);

    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IOException {
//        demo1();
//        demo2();
//        demo3();
        demo4();
    }
}
