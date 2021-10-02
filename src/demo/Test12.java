package demo;

public class Test12 {
    public static void main(String[] args) {
        int y = getNumber(30);
        System.out.println(y);
    }
    public static int getNumber(int num) {
        if (num<3){
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
}
