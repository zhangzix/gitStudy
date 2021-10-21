package SuanFa;

import java.math.BigDecimal;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        One();
        Two();
        Three();
        Four();
        Six();
    }
    private static void One() {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        double round = Math.round(num);
        System.out.println(round);
    }
    private static void Two() {
        System.out.println("请输入一个4位正整数");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }
    private static void Three() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int num = Double.valueOf(s).intValue();
        BigDecimal b1 = new BigDecimal(s);
        BigDecimal b2 = new BigDecimal(num);
        System.out.println("整数部分为" + num + ",小数部分为" + b1.subtract(b2).doubleValue());
    }
    private static void Four() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("请猜测两数之和");
        int res = scanner.nextInt();
        if (res == (x + y)) {
            System.out.println("恭喜，猜测答案正确");
        } else {
            System.out.println("输入答案错误，正确答案为:" + (x + y));
        }
    }
    private static void printInfo() {
        System.out.println("---------------------");
        System.out.println("商品信息如下:");
        System.out.println("[1]     口香糖");
        System.out.println("[2]     巧克力");
        System.out.println("[3]     爆米花");
        System.out.println("[4]     果汁");
        System.out.println("[5]     显示购买总数");
        System.out.println("[6]     退出");
        System.out.println("---------------------");
    }
    private static void Six() {
        Scanner scan = new Scanner(System.in);
        int[] arr = {0, 0, 0, 0};
        String[] goods = {"口香糖", "巧克力", "爆米花", "果汁"};
        boolean flag = true;
        while (flag) {
            printInfo();
            System.out.println("请输入选项[1~6]");
            int num = scan.nextInt();
            switch (num) {
                case 1: case 2: case 3: case 4:
                    arr[num - 1] = arr[num - 1] + 1;
                    System.out.println("您购买了" + goods[num - 1]);
                    break;
                case 5:
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] != 0) {
                            System.out.println("您购买了" + arr[i] + "个" + goods[i]);
                        }
                    }
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("错误，请输入1~6以内的数字");
            }
        }
    }
}