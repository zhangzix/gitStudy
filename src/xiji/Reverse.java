package xiji;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【问题描述】
 * 设将n（n>1）个整数存放在一维数组R中。试设计一个在时间和空间两方面都尽可能高效的算法。将R中保存的序列循环左移P（P>0）个位置。
 * 例如，假设P<n，将R中的数据（X0,X1,..Xn-1）循环左移P个位置后，变换为（Xp, XP+1,..Xn-1,X0,X1,..Xp-1）
 * 【输入形式】
 * 循环移动的位数，数组中数据的个数，循环前的数组
 * 【输出形式】
 * 循环后的数组
 * 【样例输入】
 * 3 5 1 2 3 4 5
 * 【样例输出】
 * 4 5 1 2 3
 * 【样例说明】
 * 请大家注意，循环位移的位数可能超过数组中元素个数；输入与输出的数据均以空格分割，其中输入的数据中第一个是循环移位的位数，第二个是数组中数据的个数，后面的是数组中的数据。
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mov_num = sc.nextInt();
        int arr_size = sc.nextInt();
        mov_num = mov_num % arr_size;
        int[] arr = new int[arr_size];
        for (int i = 0; i < arr_size; i++) {
            arr[i] = sc.nextInt();
        }
        int[] arr2 = Arrays.copyOfRange(arr, 0, mov_num);
        for (int i = mov_num; i < arr_size; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int j : arr2) {
            System.out.print(j + " ");
        }
    }
}
