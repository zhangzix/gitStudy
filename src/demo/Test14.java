package demo;

import java.util.Scanner;

public class Test14 {
    public static void main(String[] args) {
        System.out.println("请输入一个十进制正整数数值:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; num >= 2; i++) {
            sb.append(num%2);
            num = num / 2;
        }
        sb.append(num);
        String res = sb.reverse().toString();
        System.out.println(res);
    }
}
