package calculator;

public class Main {
    public static void main(String[] args) {
         Circle circle   = new Circle(5,"black","red");
        Rectangle rectangle = new Rectangle(4,6,"black","blue");
        Triangle triangle = new Triangle(3,5,7,"black","orange");

        /* мне посоветовали использовать StringBuffer для более эффективной конкатенации строк
        System.out.println("Circle: Area = "+circle.calculateArea() +", Perimetr = "+ circle.calculateArea()+", Border Color = "+ circle.getBorderColor() +", Fill Colors = "+ circle.getFillColor());
        System.out.println("Rectangle: Area = "+rectangle.calculateArea() +", Perimetr = "+ rectangle.calculateArea()+", Border Color = "+ rectangle.getBorderColor() +", Fill Colors = "+ rectangle.getFillColor());
        System.out.println("Triangle: Area = "+triangle.calculateArea() +", Perimetr = "+ triangle.calculateArea()+", Border Color = "+ triangle.getBorderColor() +", Fill Colors = "+ triangle.getFillColor());
        */

        StringBuffer output = new StringBuffer();
        output.append("Circle: Area=").append(circle.calculateArea()).append(", Perimeter=").append(circle.calculatePerimeter()).append(", Border Color=").append(circle.getBorderColor()).append(", Fill Color=").append(circle.getFillColor()).append("\n");
        output.append("Rectangle: Area=").append(rectangle.calculateArea()).append(", Perimeter=").append(rectangle.calculatePerimeter()).append(", Border Color=").append(rectangle.getBorderColor()).append(", Fill Color=").append(rectangle.getFillColor()).append("\n");
        output.append("Triangle: Area=").append(triangle.calculateArea()).append(", Perimeter=").append(triangle.calculatePerimeter()).append(", Border Color=").append(triangle.getBorderColor()).append(", Fill Color=").append(triangle.getFillColor());

        System.out.println(output.toString());

    }
}
