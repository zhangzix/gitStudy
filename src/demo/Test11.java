package demo;

import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个数");
        int x, y;
        x = sc.nextInt();
        y = sc.nextInt();
        System.out.println("请猜测这两数之和");
        int t = sc.nextInt();
        if (t == (x + y)) {
            System.out.println("猜测答案正确");
        } else {
            System.out.println("猜测错误，正确答案为"+(x+y));
        }
    }
}
