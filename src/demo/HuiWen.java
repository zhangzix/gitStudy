package demo;

import java.util.Random;

public class HuiWen {
    public static void main(String[] args) {
        Random random = new Random();
        boolean flag = true;
        while (flag) {
            String t = "";
            for (int i = 0; i < 5; i++) {
                t += random.nextInt(9);
            }
            int num = Integer.parseInt(t);
            flag = !isHuiWen(num);
            if (flag) {
                System.out.println(t + "不是回文");
            } else System.out.println(t + "是回文");
        }
    }

    private static boolean isHuiWen(int num) {
        boolean flag = true;
        String t = num + "";
        char[] chars = t.toCharArray();
        int len = chars.length;
        for (int i = 0; i <= len / 2; i++) {
            if (chars[i] != chars[len - 1 - i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
