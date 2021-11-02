package cs2017.v3;

import cs2017.v0.Point;

public class Circle implements Shape {
    private double radius;
    private Point point;

    public Circle(double radius, Point point) {
        this.radius = radius;
        this.point = point;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getC() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "圆{" +
                "半径=" + radius +
                ", point=[" + point.getX() + "," + point.getY() +
                "]}";
    }
}
