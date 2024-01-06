package shape;

public class Circle {
    private double radius;
    private String color;
    protected static final double PI = 3.14;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * get area.
     * @return area of current circle
     */
    public double getArea() {
        return this.radius * this.radius * PI;
    }

    /**
     * get des.
     * @return description
     */
    public String toString() {
        return "Circle[radius=" + getRadius() + ",color=" + getColor() + "]";
    }
}
