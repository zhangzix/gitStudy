package demo;


import org.junit.Test;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this(10, 10);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "宽度=" + width +
                ", 高度=" + height +
                ", 面积=" + getArea() +
                ", 周长=" + getPerimeter() +
                '}';
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        System.out.println(r1);
    }
}