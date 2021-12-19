package xiji;

import java.util.Scanner;

/**
 * 排序编程作业-公民办共用
 */
public class SortingMethod {
    public static void main(String[] args) {
//        MaoPao();
//        SelectSort();
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
//        quicklySort();
    }

    /**
     * 1、冒泡排序法
     * 【问题描述】
     * 输入n个整数，输出其中最小的k个
     * 【输入形式】
     * 第一行：整数数组
     * 第二行：k
     * 【输出形式】
     * 数组中最小的k个数字
     */
    private static void MaoPao() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int needSize = scanner.nextInt();

        for (int i = 0; i < arr.length - 1; i++) {
            int temp;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        displayArrays(arr, needSize);
    }

    /**
     * 2、选择排序法
     * 【问题描述】
     * 使用选择排序法，对输入数组进行排序
     * 【输入形式】
     * 整型数组A
     * 【输出形式】
     * 排序后的数组
     */
    private static void SelectSort() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        int[] arrays = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arrays[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < arrays.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[minIndex] > arrays[j]) {
                    minIndex = j;
                }
            }
            int temp = arrays[minIndex];
            arrays[minIndex] = arrays[i];
            arrays[i] = temp;
        }
        displayArrays(arrays, arrays.length);
    }

    private static void quicklySort() {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        displayArrays(arr, arrSize);
    }

    public static void quickSoft(int[] arr, int left, int right) {

        if (arr == null || arr.length < 0) {
            return;
        }
        if (left > right) {
            return;
        }
        int key = arr[left];
        int l = left;
        int r = right;
//        先移动右边
        while (l != r) {
//            当右边的值大于等于key时移动,
            while (arr[r] >= key && l < r) {
                r--;
            }
//            当左边的值小于等于key时移动,
            while (arr[l] <= key && l < r) {
                l++;
            }
//            当两个指针全部停的时候交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
//        当l=r时，arr[left]和arr[l]两个值交换
        arr[left] = arr[l];
        arr[l] = key;
        quickSoft(arr, left,    l - 1);
        quickSoft(arr, l + 1, right);

    }

    private static void displayArrays(int arr[], int size) {
        if (arr.length < size) size = arr.length;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
