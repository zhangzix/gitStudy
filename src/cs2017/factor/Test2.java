package cs2017.factor;

import cs2017.v0.Point;
import cs2017.v2.Circle;
import cs2017.v2.Rectangle;
import cs2017.v2.Shape;

public class Test2 {
    public static void main(String[] args) {
        Shape circle = new Circle(3, new Point(3, 3));
        System.out.println(circle);
        System.out.println("圆的面积:" + circle.getArea());
        System.out.println("------------------------");
        Shape rectangle = new Rectangle(4, 5, new Point(0, 0));
        System.out.println(rectangle);
        System.out.println("长方形的面积:" + rectangle.getArea());

    }
}
