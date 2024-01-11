package calculator;

class Circle implements Shape {
    private double radius;
    private String borderColor;
    private String fillColor;

    public Circle(double radius, String borderColor, String fillColor) {
        this.radius = radius;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double calculateArea() {
        return Math.PI * (radius);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * (radius);
    }

    @Override
    public String getBorderColor() {
        return fillColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }
    public String getCircleInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Circle: Area=");
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
