public class Circle implements GeometricObject {
    public static final double PI = 3.14;
    private Point center;
    private double radius;

    public Circle() {
    }

    /**
     * ok.
     */
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * ok.
     */
    public double getArea() {
        return PI * radius * radius;
    }

    /**
     * ok.
     */
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    /**
     * ok.
     */
    public String getInfo() {
        double pointX = center.getPointX();
        double pointY = center.getPointY();
        return "Circle[("
                + String.format("%.2f", pointX) + ","
                + String.format("%.2f", pointY) + "),r="
                + String.format("%.2f", radius) + "]";
    }
}
