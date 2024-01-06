import java.util.Objects;

public class Circle extends Shape {
    protected Point center;
    protected double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**
     * ad.
     * 
     * @param center c
     * @param radius r
     * @param color  c
     * @param filled f
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.center = center;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    /**
     * ad.
     */
    public String toString() {
        String center = this.center.toString();
        double radius = Math.floor(this.getRadius() * 10) / 10;
        String color = this.getColor();
        boolean isFilled = this.isFilled();

        return "Circle[center=" + center + ",radius=" + radius
                + ",color=" + color + ",filled=" + isFilled + "]";
    }

    /**
     * ad.
     */
    public boolean equals(Object o) {
        if (!(o instanceof Circle)) {
            return false;
        }
        Circle circle = (Circle) o;
        return circle.getCenter().equals(this.center)
                && Math.abs(circle.getRadius() - this.radius) <= 0.001;
    }

    public int hashCode() {
        return Objects.hash(this);
    }
}
