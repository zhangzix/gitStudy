package cs2017.v2;

import cs2017.v0.Point;

public class Circle extends Shape {
    private double radius;


    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, Point point) {
        this.radius = radius;
        this.point = point;
    }


    public double getRadius() {
        return radius;
    }


    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return super.toString() + ",圆{" +
                "radius:" + radius +
                '}';
    }
}
