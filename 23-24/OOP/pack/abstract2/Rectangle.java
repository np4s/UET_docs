import java.util.Objects;

public class Rectangle extends Shape {
    protected Point topLeft;
    protected double width;
    protected double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * set.
     * 
     * @param width  w
     * @param length l
     * @param color  c
     * @param filled f
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * lk.
     */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
        this.topLeft = topLeft;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    /**
     * lk.
     */
    public String toString() {
        String center = this.topLeft.toString();
        double width = Math.floor(this.getWidth() * 10) / 10;
        double length = Math.floor(this.getLength() * 10) / 10;
        String color = this.getColor();
        boolean isFilled = this.isFilled();

        return "Rectangle[topLeft=" + center
                + ",width=" + width + ",length=" + length
                + ",color=" + color + ",filled=" + isFilled + "]";
    }

    /**
     * lk.
     */
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return rectangle.getTopLeft().equals(this.topLeft)
                && Math.abs(rectangle.getWidth() - this.width) <= 0.001
                && Math.abs(rectangle.getLength() - this.length) <= 0.001;
    }

    public int hashCode() {
        return Objects.hash(this);
    }
}
