package cs2017.factor;

import cs2017.v0.Point;
import cs2017.v1.Circle;
import cs2017.v1.Rectangle;
import cs2017.v1.Shape;

public class Test1 {
    public static void main(String[] args) {
        Shape circle = new Circle(new Point(3.0, 4.0), 5);
        System.out.println(circle.toString());
        System.out.println("面积为:" + circle.getArea());

        Shape rectangle = new Rectangle(new Point(0, 0), 4, 5);
        System.out.println(rectangle.toString());
        System.out.println("面积为:"+rectangle.getArea());
    }
}
