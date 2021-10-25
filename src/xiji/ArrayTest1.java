package xiji;

import java.util.Scanner;

/**
 * 【问题描述】
 * 已知一个整数序列A长度为N其中若存在a且a的个数大于N/2则称为A的主元素
 * 例如0 5 5 3 5 7 5 5 则为主元素 5
 * 又如0 5 5 3 5 1 5 7则中没有主元素。
 * 假设中的个元素保存在一个一维数组中，请设计一个尽可能高效的算法，找出的主元素。若存在主元素则输出该元素否则输出
 * 【输入形式】
 * 一个整数数组
 * 【输出形式】
 * 主元素
 * 【样例输入】
 * 0 5 5 3 5 7 5 5
 * 【样例输出】
 * 5
 * 【样例说明】
 * 长度为8，共有5个"5"
 */
public class ArrayTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] sArr = line.split(" ");
        int[] arr = new int[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }
        int res = -1;
        for (int i = 0; i < arr.length / 2 + 1; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > (arr.length / 2)) {
                res = arr[i];break;
            }
        }
        System.out.println(res);

    }
}
