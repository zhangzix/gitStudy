package cs2017.v1;

import cs2017.v0.Point;

public class Circle extends Shape {
    private double radius;

    public Circle() {
    }


    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(Point point, double radius) {
        super(point);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return super.toString() + " 圆形[半径:" + this.radius + "]";
    }

}
