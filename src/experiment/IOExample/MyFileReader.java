package experiment.IOExample;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流学习
 */
public class MyFileReader {
    public static void main(String[] args) {

    }

    @Test
    /**
     * FileReader的基本使用
     */
    public void Test1() {
        String path = "demo.txt";
        FileReader reader = null;
        try {
            reader = new FileReader(path);
            int readLen = 0;
            char[] charsBuf = new char[8];
            while ((readLen = reader.read(charsBuf)) != -1) {
                System.out.print(new String(charsBuf, 0, readLen));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    /**
     * FileWriter的基本书用
     */
    public void Test2() {
        FileWriter writer = null;
        try {
            writer = new FileWriter("demo.txt");
            writer.write("H");
            writer.write("Hello");
            char[] t = {' ', 'w', 'o' };
            writer.write(t);
            writer.write("这是什么鬼".toCharArray(), 0, 5);
            writer.write("你好北京");
            writer.write("????",0,2);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
