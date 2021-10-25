package xiji;

import java.util.Scanner;

/**
 * 【问题描述】
 * 对于1到n的所有自然数，计算0到n所有数字（0-9之间的数字）出现的次数分布。
 * 【输入形式】
 * 一个整数n（n <= 100000）
 * 【输出形式】
 * 10个数字，空格隔开，对应0-9数字在1..n这个序列中出现的次数总和。
 * 【样例输入】
 * 11
 * 【样例输出】
 * 1 4 1 1 1 1 1 1 1 1
 * 【样例输入】
 * 10000
 * 【样例输出】
 * 2893 4001 4000 4000 4000 4000 4000 4000 4000 4000
 * 【评分标准】
 * 输出的10个数之间用空格区分。
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        int arr[] = new int[10];
        try {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            for (int i = 1; i <= num; i++) {
                String s = "" + i;
                for (int j = 0; j < s.length(); j++) {
                    int t = Integer.parseInt(s.charAt(j) + "");
                    arr[t] = arr[t] + 1;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }

        } catch (Exception e) {

        }
    }
}
