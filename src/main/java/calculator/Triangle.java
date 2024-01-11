package calculator;

class Triangle implements Shape{
    private double side1;
    private double side2;
    private double side3;
    private String borderColor;
    private String fillColor;

    public Triangle(double side1, double side2, double side3, String borderColor, String fillColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
    @Override
    public double calculateArea(){
        double s = (side1+side2+side3)/2;
        return Math.sqrt(s*(s - side1 )*(s - side2)* (s - side3));
    }
    @Override
    public double calculatePerimeter(){
        return (side1+side2+side3);
    }
    @Override
    public String getBorderColor(){return  borderColor;}
    @Override
    public String getFillColor(){return fillColor;}

    public String getTriangleInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Triangle: Area=");
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
