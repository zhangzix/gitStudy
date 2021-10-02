package demo;

import java.util.Scanner;

public class Test13 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年 月 日空格分开");
        int year, month, day;
        int res_Y=0, res_M=0, res_D=0;
        year = sc.nextInt();
        month = sc.nextInt();
        day = sc.nextInt();
        if (day == 1) {
            if (month == 1) {
                res_Y = year - 1;res_M = 12;res_D = 31;
            }
            else if (month == 3) {
                res_Y = year;res_M = 2;
                res_D = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? 29 : 28;
            }
            else{
                switch (month){
                    case 2: case 4: case 6: case 8: case 9: case 11:
                        res_D=31;res_M=month-1;res_Y=year;break;
                    default:
                        res_D=30;res_M=month-1;res_Y=year;break;
                }
            }

        }
        else{
            res_D=day-1;
            res_M=month;
            res_Y=year;
        }
        System.out.println(res_Y+"年"+res_M+"月"+res_D+"日");
    }
}
