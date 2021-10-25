package xiji;

import java.util.Scanner;

/**
 * 【问题描述】
 * 已知具有n个数组元素的一维数组A,请写一个算法，将该数组中所有值为0的元素都依次移到数组的前端，其他元素依次输出。
 * 【输入形式】
 * 第一个数为输入数字的个数，其后为数组的数字
 * 【输出形式】
 * 输出相应的数组
 * 【样例输入】
 * 5 1 2 3 4 0
 * 【样例输出】
 * 0 1 2 3 4
 */
public class ArrayTest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int arr[] = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < arrSize; i++) {
            if (arr[i] == 0)
                System.out.print(0 + " ");
        }
        for (int i = 0; i < arrSize; i++) {
            if (arr[i]!=0)
                System.out.print(arr[i]+" ");

        }
    }
}
