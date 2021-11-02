package cs2017.v2;

import cs2017.v0.Point;

public abstract class Shape {
    public Point point;

    public abstract double getArea();

    public String toString() {
        return "点的位置:{" + point.getX() + "," + point.getY() + "}";
    }
}
