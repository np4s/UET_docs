package shape;

public class Cylinder extends Circle{
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * get volume.
     * @return Cylinder's volume
     */
    public double getVolume() {
        return super.getArea() * height;
    }

    /**
     * get des.
     * @return description
     */
    public String toString() {
        return "Cylinder[" + super.toString() + ",height=" + height + "]";
    }

    /**
     * get area.
     * @return Area
     */
    public double getArea() {
        return 2 * super.getArea() + 2 * PI * getRadius() * getHeight();
    }
    
}
