package demo;

import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int num = sc.nextInt();
        get_AllSum(num);
    }

    public static void get_AllSum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            int t = 1;
            for (int j = 1; j <= i; j++) {
                t *= j;
            }
            sum += t;
        }
        System.out.print("s=");
        for (int i = 1; i <= num; i++) {
            if (i == num) {
                System.out.print(i + "!=" + sum);
            } else {
                System.out.print(i + "!+");
            }
        }
    }
}
