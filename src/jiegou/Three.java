package jiegou;

import java.util.Scanner;

/**
 * 【问题描述】
 * 将整数数组A[0..n]，将其分为两部分，左边所有元素为奇数，右边所有元素为偶数。数组元素个数不超过１０００。
 * 【输入形式】
 * 以逗号隔开的所有元素
 * 【输出形式】
 * 依次打印调整后的数组元素，元素间以逗号隔开。奇数序列和偶数序列分别按原序列中的顺序依次输出
 * 【样例输入】1,2,33,8,5
 * 【样例输出】 1,33,5,2,8
 */
public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String numStr = sc.nextLine();
        int size = 0;
        int[] arr = new int[1000];
        for (String str : numStr.split(",")) {
            int num = Integer.parseInt(str);
            if (num % 2 == 1) {
                arr[size] = num;
                size++;
            }
        }
        for (String str : numStr.split(",")) {
            int num = Integer.parseInt(str);
            if (num % 2 == 0) {
                arr[size] = num;
                size++;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            String sep = (i == size - 1) ? "" : ",";
            System.out.print(sep);
        }

    }
}
