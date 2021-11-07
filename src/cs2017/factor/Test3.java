package cs2017.factor;

import cs2017.v0.Point;
import cs2017.v3.Circle;
import cs2017.v3.Rectangle;
import cs2017.v3.Shape;

public class Test3 {
    public static void main(String[] args) {
        Shape circle = new Circle(3, new Point(3, 3));
        System.out.println(circle);
        System.out.println("圆的面积:" + circle.getArea());
        System.out.println("圆的周长:" + circle.getC());
        System.out.println("------------------------");
        Shape rectangle = new Rectangle(4, 5, new Point(0, 0));
        System.out.println(rectangle);
        System.out.println("长方形的面积:" + rectangle.getArea());
        System.out.println("长方形的周长:" + rectangle.getC());
    }
}

abstract class A {
    private String name;

}

class B {
    void C() {

    }
}

class C extends B {
    @Override
        protected void C() {

    }
}