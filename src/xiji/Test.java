package xiji;

import java.util.Scanner;

/**
 * 获取希冀输入的测试数据
 */
public class Test {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            System.out.println(line);
        } catch (Exception e) {
        }

    }
}
