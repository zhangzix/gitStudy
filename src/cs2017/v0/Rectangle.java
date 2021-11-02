package cs2017.v0;

public class Rectangle extends Point {
    private double l;
    private double w;

    public Rectangle() {
    }

    public Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    public Rectangle(double x, double y, double l, double w) {
        super(x, y);
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

    public double getArea() {
        return this.l * this.w;
    }

    @Override
    public String toString() {
        return super.toString() + "长:" + this.l + ",宽:" + this.w;
    }

}
