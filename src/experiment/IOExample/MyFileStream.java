package experiment.IOExample;

import org.junit.Test;

import java.io.*;

/**
 * 测试IO
 */
public class MyFileStream {
    public static void main(String[] args) {
        new MyFileStream().Test2();
    }

    @Test
    /**
     * FileInputStream的read()和read(byte[])的使用
     */
    public void Test1() {
        String path = "D:\\JetBrains\\IntelliJIDEA\\IDEA-workplace\\Study\\src\\experiment\\IOExample\\MyFileOutput.java";
        InputStream input = null;
        byte[] bytes = new byte[8];
        try {
            int readLen = 0;
            input = new FileInputStream(path);
            while ((readLen = input.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readLen));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    /**
     * FileOutputStream的简单使用
     */
    public void Test2() {
        String path = "demo.txt";
        OutputStream out = null;
        try {
            out = new FileOutputStream(path, true);
//            System.out.println("请输入保存的字符串");
//            Scanner scanner = new Scanner(System.in);
//            String line = scanner.nextLine();
            String line = "Hello 你好";
            out.write(line.getBytes(), 0, line.length());
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    /**
     * 文件的复制
     */
    public void FileCopy() {
        InputStream input = null;
        OutputStream out = null;
        byte[] buf = new byte[1024];
        int readLen = 0;
        String path1 = "C:\\Users\\PC\\Desktop\\Python.png";
        String path2 = "PythonCopy.png";
        try {
            input = new FileInputStream(path1);
            out = new FileOutputStream(path2);
            while ((readLen = input.read(buf)) != -1) {
                out.write(buf, 0, readLen);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}