package demo;

public class Print {
    public static void main(String args[]) {
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 2 * i + 1; k++)
                System.out.print("*");
            System.out.print("\n");
        }
    }
}
