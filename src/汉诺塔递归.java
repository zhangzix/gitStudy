public class 汉诺塔递归 {
    public static int count = 0;

    public static void main(String[] args) {
        move(32, 'A', 'B', 'C');
        System.out.println("移动次数为" + count);
    }

    public static void move(int num, char A, char B, char C) {
        if (num == 1) {
            System.out.println(++count + ": " + A + "->" + C);
        } else {
            move(num - 1, A, C, B);
            System.out.println(++count + ": " + A + "->" + C);
            move(num - 1, B, A, C);
        }
    }
}
