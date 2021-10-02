package demo;

public class AddDemo {
    public static void main(String[] args) {
        String a = "123.5";String b = "456.5";
        System.out.println(Add(a, b));
    }
    public static int Add(int a, int b) {
        return a + b;
    }
    public static double Add(double a, double b) {
        return a + b;
    }
    public static double Add(String a, String b) {
        return Double.parseDouble(a) + Double.parseDouble(b);
    }
}
