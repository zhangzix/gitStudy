package cs2017.factor;

import cs2017.v0.Circle;
import cs2017.v0.Point;
import cs2017.v0.Rectangle;

public class Test {
    public static void main(String[] args) {
        System.out.println("---------------------------");
        System.out.println("圆:");
        Point circle = new Circle(3, 4, 3);
        System.out.println(circle.toString());
        if (circle instanceof Circle) {
            System.out.println("面积为:"+((Circle) circle).getArea());
        }
        System.out.println("---------------------------");
        System.out.println("长方形:");
        Point rectangle = new Rectangle(0, 0, 4, 5);
        System.out.println(rectangle.toString());
        if (rectangle instanceof Rectangle){
            System.out.println("面积为:"+((Rectangle) rectangle).getArea());
        }
        System.out.println("---------------------------");


    }
}
