package demo;

public class Test16 {
    public static void main(String[] args) {
        int x = 10, y = 10;
        print$(x, y, '$');
    }

    public static void print$(int x, int y, char ch) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(ch);

            }
            System.out.println();

        }
    }
}
