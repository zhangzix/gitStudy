package demo;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        int size = 0;
        int BSize = 10;
        int[] y_arr = new int[BSize];
        System.out.println("请输入一个十进制正整数数值:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = BSize - 1; num >= 2; i--) {
            y_arr[i] = num % 2;
            num /= 2;
            size += 1;
        }
        y_arr[BSize - size - 1] = num;
        for (int i = y_arr.length - size - 1; i < y_arr.length; i++) {
            System.out.print(y_arr[i]);
        }
    }
}
