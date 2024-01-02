package calculator;

class Rectangle implements Shape {
    private double width;
    public double height;
    private String borderColor;
    private String fillColor;

    public Rectangle(double width, double height, String borderColor, String fillColor) {
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getBorderColor() {

        return borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }
}