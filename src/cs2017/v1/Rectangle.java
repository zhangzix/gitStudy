package cs2017.v1;

import cs2017.v0.Point;

public class Rectangle extends Shape {
    private double l;
    private double w;

    public Rectangle() {
    }

    public Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    public Rectangle(Point point, double l, double w) {
        super(point);
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

    @Override
    public String toString() {
        return super.toString() + "长方形[长:" + this.l + ",宽:" + this.w + "]";
    }

    public double getArea() {
        return this.l * this.w;
    }

}
