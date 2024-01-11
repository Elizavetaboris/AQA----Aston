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
    public String getBorderColor() {return borderColor;}

    @Override
    public String getFillColor() {
        return fillColor;
    }
    public String getRectangleInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Rectangle: Area=");
        info.append(calculateArea());
        info.append(", Perimeter=");
        info.append(calculatePerimeter());
        info.append(", Border Color=");
        info.append(borderColor);
        info.append(", Fill Color=");
        info.append(fillColor);
        return info.toString();
    }
}