package experiment;

public class Rectangle {
    private double length;
    private double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double getArea() {
        return this.length * this.width;
    }
}
class Cuboid {
    private Rectangle rectangle;
    private double height;
    public Rectangle getRectangle() {
        return rectangle;
    }
    public Cuboid(Rectangle rectangle, double height) {
        this.rectangle = rectangle;
        this.height = height;
    }
    public double getVolume() {
        return this.rectangle.getArea() * this.height;
    }
}
//class Test {
//    public static void main(String[] args) {
//        Rectangle rectangle = new Rectangle(10, 5);
//        System.out.println("长方形的面积为:" + rectangle.getArea());
//        Cuboid cuboid = new Cuboid(rectangle, 5);
//        System.out.println("长方体的体积为:" + cuboid.getVolume());
//    }
//}
