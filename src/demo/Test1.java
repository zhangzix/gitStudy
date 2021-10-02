package demo;

public class Test1 {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
        get_WanShu();
    }

    public static void get_SuShu() {
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

    public static void get_WanShu() {
        for (int i = 2; i <= 1000; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum==i){
                System.out.print(i+" ");
            }
        }
    }
}
