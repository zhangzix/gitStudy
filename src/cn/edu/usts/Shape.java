package cn.edu.usts;

public interface Shape {
     double getPerimeter();
     double getArea();
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public double getPerimeter() {
        return 2 * (this.length + this.width);
    }

    public double getArea() {
        return (this.length * this.width);
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", 周长=" + this.getPerimeter() +
                ", 面积=" + this.getArea() +
                '}';
    }
}

class Circle implements Shape {
    private double R;

    public Circle(double R) {
        this.R = R;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * R;
    }

    @Override
    public double getArea() {
        return Math.PI * R * R;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "半径=" + R +
                ", 周长=" + this.getPerimeter() +
                ", 面积=" + this.getArea() +
                '}';
    }

    public static void main(String[] args) {
        Shape r1 = new Rectangle(10, 20);
        System.out.println(r1);
        Shape c1 = new Circle(5);
        System.out.println(c1);
    }
}
