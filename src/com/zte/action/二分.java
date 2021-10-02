package com.zte.action;


public class 二分 {
    public static void main(String[] args) {

        long t1 = System.nanoTime();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 4;
        int index = getindex(arr, target);
        if (index != -1) {
            System.out.println("index:" + index + " " + arr[index]);
        } else {
            System.out.println(index);
        }

        System.out.println(System.nanoTime() - t1);
    }

    /**
     * 二分法查找元素
     *
     * @param arr
     * @param target
     * @return
     */
    public static int getindex(int[] arr, int target) {
        int begin = 0;
        int end = arr.length - 1;
        int mid = (begin + end) / 2;
        while (true) {
            if (begin > end) {
                return -1;
            }
            if (arr[mid] == target) {
                return mid;
            } else {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
                mid = (begin + end) / 2;
            }

        }
    }
}
