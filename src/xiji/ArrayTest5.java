package xiji;

import java.util.Scanner;

/**
 * 【问题描述】
 * 设s、t 为两个字符串，两个字符串分为两行输出，判断t 是否为s 的子串。如果是，输出子串所在位置（第一个字符，字符串的起始位置从0开始），否则输出-1
 * 【输入形式】
 * 两行字符串，第一行字符串是s；第二行是字符串t
 * 【输出形式】
 * 对应的字符
 * 【样例输入】
 * abcdkkk
 * bc
 * 【样例输出】
 * 1
 */
public class ArrayTest5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        System.out.println(line1.indexOf(line2));
    }
}
