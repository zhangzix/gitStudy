package xiji;

import java.util.Scanner;

/**
 * 【问题描述】
 * 编写一个程序，判断一个字符串是否为"回文"（顺读和倒读都一样的字符串称为"回文"）。
 * 【输入形式】
 * 长度小于100的任意字符串
 * 【输出形式】
 * 如果输入字符串是回文，则输出"yes"；如果字符串不是回文，则输出"no"
 * 【样例1输入】
 * abcdcba
 * 【样例1输出】
 * yes
 * 【样例输入2】
 * abcdfsfdsg
 * 【样例2输出】
 * no
 */
public class ArrayTest4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuilder sb = new StringBuilder(line);
        String res = sb.reverse().toString().equals(line) ? "yes" : "no";
        System.out.println(res);
    }
}
