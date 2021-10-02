import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2 {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int num = 0;
        try {
            num = new Scanner(System.in).nextInt();
            for (int i = 0; i < 10; i++) {
                map.put(i + "", 0);
            }
            for (int i = 1; i <= num; i++) {
                getNum(i);
            }
            for (Integer value : map.values()) {
                System.out.print(value + " ");
            }
        } catch (Exception e) {

        }

    }

    public static void getNum(int num) {
        String t = num + "";
        char[] arr = t.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i] + "", map.get(arr[i] + "") + 1);
        }

    }
}
