package demo;

public class Test2 {
    public static void main(String[] args) {
        for (int i = 200; i <= 300; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    if (i == j) {
                        System.out.print(i + " ");
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
