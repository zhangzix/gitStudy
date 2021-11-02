package cs2017.v2;

import cs2017.v0.Point;

public class Rectangle extends Shape {
    private double l;
    private double w;


    public Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    public Rectangle(double l, double w, Point point) {
        this.l = l;
        this.w = w;
        this.point = point;
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

    @Override
    public double getArea() {
        return l * w;
    }

    @Override
    public String toString() {
        return super.toString() + ",长方形{" +
                "长:" + l +
                ", 宽:" + w +
                '}';
    }
}
