package experiment;

import java.util.Scanner;

public interface Shape {
    double getArea();//求一个形状的面积

    double getPerimeter();//求一个形状的周长

    String getStatus();//获取类型
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String getStatus() {
        return "Circle";
    }

    @Override
    public String toString() {
        return "圆{" +
                "半径=" + radius +
                ",周长=" + this.getPerimeter() +
                ",面积=" + this.getArea() +
                '}';
    }
}

class Square implements Shape {
    private double length;
    private double width;

    public Square(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return this.length * this.width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.length + this.width);
    }

    @Override
    public String getStatus() {
        return "Square";
    }

    @Override
    public String toString() {
        return "长方形{" +
                "长=" + length +
                ", 宽=" + width +
                ", 周长=" + getPerimeter() +
                ", 面积=" + getArea() +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        try {
            double radius = getRadius();
            Shape circle = new Circle(radius);
            System.out.println("图形为" + circle.getStatus() + "，半径为:" + radius + ",面积为:" + circle.getArea());
        } catch (Exception e) {
            System.out.println("请重新输入半径，半径不能为负数");
        }
    }
    public static double getRadius() throws Exception {
        System.out.println("请输入半径");
        Scanner scanner = new Scanner(System.in);
        double v = scanner.nextDouble();
        if (v < 0)
            throw new Exception("不能为负数");
        return v;
    }
}