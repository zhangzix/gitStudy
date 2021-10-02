package demo;

import java.util.Scanner;

public class Test15 {
    static final double PI = 3.14;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        System.out.println(circleArea(radius));
    }

    public static double circleArea(double radius) {
        return Math.pow(radius, 2) * PI;
    }
}
