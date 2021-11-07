package experiment.IOExample;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


public class BufReaderTest {
    @Test
    public void Test() {
        int j = 0;
        int x = j--;
        System.out.println(x);
//        System.out.println(x++ + ++x);//2
        System.out.println(++x + x++);//2
        int i = 0;

    }

    @Test
    public void BufReaderTest1() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("demo.txt"));
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void BufStreamTest1() {
        BufferedInputStream input = null;
        BufferedOutputStream out = null;
        try {
            input = new BufferedInputStream(new FileInputStream("PythonCopy.png"));
            out = new BufferedOutputStream(new FileOutputStream("Copy.png"));
            int readLen = 0;
            byte[] buf = new byte[1024];
            while ((readLen = input.read(buf)) != -1) {
                out.write(buf, 0, readLen);
            }
            System.out.println("拷贝文件成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    /**
     * 字节流转字符流 然后包装流
     */
    public void InputStreamReaderTest() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("demo.txt"), StandardCharsets.UTF_8));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    @Test
    public void PropertiesTest() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("mysql.properties"));
//        for (Object key : properties.keySet()) {
//            System.out.println(key + ":" + properties.getProperty((String) key));
//        }
        properties.list(System.out);
        properties.setProperty("charset", "utf8");
        properties.store(new FileWriter("mysql.properties"), null);
        properties.list(System.out);
    }

    @Test
    public void PropertiesExample() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("name", "tom");
        properties.setProperty("age", "5");
        properties.setProperty("color", "red");
        properties.store(new FileWriter("dog.properties"), null);

        properties.load(new FileReader("dog.properties"));
        properties.list(System.out);
        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");
        Dog dog = new Dog(name, age, color);
        System.out.println("-------------");
        System.out.println(dog);
//      对Dog对象序列化
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("Dog.dat"));
        stream.writeObject(dog);
        stream.close();
        System.out.println("序列化完成");
//
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Dog.dat"));
        Dog d = (Dog)ois.readObject();
        System.out.println(d.getClass());
        System.out.println(d);
        ois.close();

    }

}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}