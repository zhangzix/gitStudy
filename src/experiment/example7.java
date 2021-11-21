package experiment;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 实验7  Java高级I/O流程序设计
 */
public class example7 {
    public static void main(String[] args) {
        Test3();
    }

    /**
     * 从键盘上输入的一行内容写入到文件copyfile.txt中
     */
    public static void copyFile() {
        File file = new File("copyfile.txt");
        BufferedReader BufR = null;
        BufferedWriter BufW = null;
        BufR = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        try {
            BufW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
            BufW.write(BufR.readLine());
            System.out.println("保存成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                BufW.close();
                BufR.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 选择一个含有中文注释的.java文件，使用FileInputStream和FileReader分别读取文件，
     * 并把内容显示在控制台上。
     * 然后使用FileOutputStream和FileWriter将文件分别将文件复制到另一个文件copyfile1.txt和 copyfile2.txt中
     */
    public static void Test2_1() {
        FileInputStream input = null;
        FileOutputStream out = null;
        File file = new File("D:\\JetBrains\\IntelliJIDEA\\IDEA-workplace\\Study\\src\\experiment\\example7.java");
        try {
            input = new FileInputStream(file);
            out = new FileOutputStream("copyfile1.txt");
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = input.read(buf)) != -1) {
                System.out.println(new String(buf, 0, readLen));
                out.write(buf, 0, readLen);
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("出现未知异常");
            e.printStackTrace();
        } finally {
            try {
                out.close();
                input.close();
                System.out.println("使用FileInputStream复制文件成功");
            } catch (IOException e) {
                System.out.println("关闭异常");
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用字符流复制文本文件
     */
    public static void Test2_2() {
        FileReader input = null;
        FileWriter out = null;
        File file = new File("D:\\JetBrains\\IntelliJIDEA\\IDEA-workplace\\Study\\src\\experiment\\example7.java");
        try {
            input = new FileReader(file);
            out = new FileWriter("copyfile2.txt");
            char[] buf = new char[1024];
            int readLen = 0;
            while ((readLen = input.read(buf)) != -1) {
                System.out.println(new String(buf, 0, readLen));
                out.write(buf, 0, readLen);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                input.close();
            } catch (IOException e) {
                System.out.println("流关闭异常");
                e.printStackTrace();
            }

        }
    }

    /**
     * 利用上机6中第3题 的Book类，创建10个相应的对象，写入到文件book2.dat中；
     * 再从文件book2.dat中读出copy到文件book3.dat中
     */
    public static void Test3() {
        ObjectInputStream input = null;
        ObjectOutputStream out = null;
        ObjectOutputStream out2 = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("book2.dat"));
            out2 = new ObjectOutputStream(new FileOutputStream("book3.dat"));
            input = new ObjectInputStream(new FileInputStream("book2.dat"));

            for (int i = 1; i <= 10; i++) {
                out.writeObject(new BookT(i, "标题" + i, "作者" + i));
            }
            System.out.println("序列化保存完成");
            for (int i = 1; i <= 10; i++) {
                BookT o = (BookT) input.readObject();
                System.out.println(o);
                out2.writeObject(o);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                out2.close();
                out.close();
                input.close();
            } catch (IOException e) {
                System.out.println("流关闭异常");
                e.printStackTrace();
            }

        }
    }
}

class BookT implements Serializable {
    int isbn;
    public String title;
    public String author;
    public BookT(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    @Override
    public String toString() {
        return "BookT{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

