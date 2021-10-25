package xiji;

import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 在不使用strcat()的前提下，实现两个字符串的连接。
 * 【输入形式】
 * 以'#'为结束符的两行字符串
 * 【输出形式】
 * 将第一行字符串连接到第二行字符串，然后打印输出
 * 【样例输入】
 * abc#
 * def#
 * 【样例输出】
 * defabc
 * 【样例说明】
 * 【评分标准】
 * 不能使用strcat()，否则不能得分
 */
public class ArrayTest6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String line2 = scanner.nextLine();
        line = line.replace("#", "");
        line2 = line2.replace("#", "");
        System.out.println(line2 + line);
    }
}
