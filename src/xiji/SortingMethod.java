package xiji;

import java.util.Scanner;

/**
 * 排序编程作业-公民办共用
 */
public class SortingMethod {
    public static void main(String[] args) {
//        MaoPao();
//        SelectSort();
//        quicklySort();
        BinarySearchMain();
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

    /**
     * 【问题描述】
     * 对待排序序列使用快速排序算法进行排序，计算第一次划分之后分界元素在序列中的位置和最终排序结果（划分和分界元素的概念参照课本）（在序列中的位置跟书上一致，从1而不是从0开始）
     * 【输入形式】
     * 序列元素个数，序列
     * 【输出形式】
     * 第一次划分之后分界元素的位置，最终排序结果
     * 【样例输入】
     * 5 0 2 1 -1 -2
     * 【样例输出】
     * 3 -2 -1 0 1 2
     */
    private static void quicklySort() {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int temp = arr[0];
        quickSoft(arr, 0, arrSize - 1);
        for (int i = 0; i < arrSize; i++) {
            if (arr[i] == temp) {
                System.out.print(i + 1 + " ");
                break;
            }

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
        quickSoft(arr, left, l - 1);
        quickSoft(arr, l + 1, right);

    }

    /**
     * 【问题描述】
     * 给定一个按值有序（升序）的N元整数数组A，采用折半查找法查找关键值k的位置，并给出查找的过程
     * 【输入形式】
     * 第一行：N
     * 第二行：A[0], A[1], ... , A[N-1]
     * 第三行：k
     * 【输出形式】
     * 第一行：k的位置（索引），若不存在则输出'no'
     * 第二行：查找的过程，每一次折半的中间（mid）位置的值，以逗号分隔。例如，1 2 3 4 5的中间位置为3，1 2 3 4的中间位置为2。
     */
    private static void BinarySearchMain() {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[size];
        String[] split = scanner.nextLine().split(",");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        int searchNum = scanner.nextInt();
        int[] indexArr = new int[size / 2];
        int resIndex = BinarySearch(arr, searchNum, indexArr);
        if (resIndex == -1)
            System.out.println("no");
        else
            System.out.println(resIndex);
        for (int i = 1; i <= indexArr[0]; i++) {
            if (i == indexArr[0]) {
                System.out.print(indexArr[i]);
            } else {
                System.out.print(indexArr[i] + ",");
            }
        }

    }

    private static int BinarySearch(int[] arr, int searchNum, int[] indexArr) {
        int low = 0, high = arr.length - 1;
        int count = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == searchNum) {
                indexArr[++count] = arr[mid];
                indexArr[0] = count;
                return mid;
            } else if (arr[mid] > searchNum) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            indexArr[++count] = arr[mid];
            indexArr[0] = count;
        }
        return -1;
    }

    /**
     * 打印数组的前size个
     */
    private static void displayArrays(int arr[], int size) {
        if (arr.length < size) size = arr.length;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
