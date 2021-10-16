package experiment;

import java.util.Random;

public interface Shape {
    double getArea();//求一个形状的面积

    double getPerimeter();//求一个形状的周长
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
        Random random = new Random();
        Shape shape;
        if (random.nextInt() % 2 == 0) {//如果随机数为偶数则生成圆对象
            shape = new Circle(5);
        } else {//否则生成长方形对象
            shape = new Square(10, 5);
        }
        System.out.println(shape);
    }
}