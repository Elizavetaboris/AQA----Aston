package calculator;

public class Main {
    public static void main(String[] args) {
        Circle circle   = new Circle(5,"black","red");
        Rectangle rectangle = new Rectangle(4,6,"black","blue");
        Triangle triangle = new Triangle(3,5,7,"black","orange");

        System.out.println(circle.getCircleInfo());
        System.out.println(triangle.getTriangleInfo());
        System.out.println(rectangle.getRectangleInfo());
    }
}
