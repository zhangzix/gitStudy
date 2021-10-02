package demo;

import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = sc.nextInt();
        get_LeapYear(year);
    }
    public static void get_LeapYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + "年是闰年");
        }else{
            System.out.println(year+"年不是闰年");
        }
    }
}
