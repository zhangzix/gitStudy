package cs2017.v3;

import cs2017.v0.Point;

public class Rectangle implements Shape {
    private double l;
    private double w;
    private Point point;

    public Rectangle(double l, double w, Point point) {
        this.l = l;
        this.w = w;
        this.point = point;
    }

    public Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getC() {
        return 0;
    }

    @Override
    public String toString() {
        return "长方形{" +
                "长=" + l +
                ", 宽=" + w +
                ", point=[" + point.getX() + "," + point.getY() +
                "]}";
    }
}
