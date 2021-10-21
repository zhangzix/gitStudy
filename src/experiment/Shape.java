package experiment;

import java.util.Random;

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
    private static String getShape(Shape shape) {
        return shape.getStatus();
    }

    public static void main(String[] args) {
        Shape shape;
        if (new Random().nextInt() % 2 == 0) {//偶数圆
            shape = new Circle(5);
        } else {//否则长方形
            shape = new Square(10, 5);
        }
        System.out.println(getShape(shape));
        System.out.println(shape);
    }
}