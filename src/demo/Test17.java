package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Test17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
        int num = 123;
        int res = reverseNum(num);
        System.out.println("第二题");
        System.out.println("原:" + num + "反转:" + res);
        System.out.println("第三题");
        System.out.println("数列第30个为" + getNumber(30));
        System.out.println("第四题");
        System.out.println("(0,0),(3,4)两点距离为" + distance(0, 3, 0, 4));
        System.out.println("第五题");
        randomNum();

    }

    public static int reverseNum(int x) {
        String y = x + "";
        StringBuilder sb = new StringBuilder(y);
        String res = sb.reverse().toString();
        return Integer.parseInt(res);
    }

    public static int getNumber(int num) {
        if (num < 3) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int temp = 0;
        for (int i = 3; i <= num; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    public static double distance(double x1, double x2, double y1, double y2) {
        return Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), 0.5);
    }

    static Map<Integer, Integer> map = new HashMap<>();

    public static void randomNum() {
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int x = random.nextInt(10);
            if (map.containsKey(x)) {
                int count = map.get(x) + 1;
                map.put(x, count);
            } else {
                map.put(x, 1);
            }
        }
        for (int j = 0; j < 10; j++) {
            int count = map.get(j);
            double rate = count / 100.0;
            System.out.println(j + "数字出现了" + count + "次，概率为" + rate);
        }
    }
}
