package cs2017.v1;

import cs2017.v0.Point;

public class Shape {
    private Point point;

    public Shape() {
    }

    public Shape(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "point=" + point.getX() + "," + point.getY() +
                '}';
    }

    public double getArea() {
        return 0;
    }

    ;

}
