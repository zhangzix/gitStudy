package demo;

import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        String s = sc.nextLine();
        int sum = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sum += Integer.parseInt(chars[i] + "");
        }
        System.out.println(s + ":" + sum);
    }
}
