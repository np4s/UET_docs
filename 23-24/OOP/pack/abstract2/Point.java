import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * ba.
     * 
     * @param newPoint a
     * @return c
     */
    public double distance(Point newPoint) {
        double x = Math.pow(this.pointX - newPoint.getPointX(), 2);
        double y = Math.pow(this.pointY - newPoint.getPointY(), 2);
        return Math.sqrt(x + y);
    }

    /**
     * bac.
     */
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return Math.abs(point.getPointX() - pointX) <= 0.001
                && Math.abs(point.getPointY() - pointY) <= 0.001;
    }

    public int hashCode() {
        return Objects.hash(this);
    }

    /**
     * lk.
     */
    public String toString() {
        double reX = Math.floor(pointX * 10) / 10;
        double reY = Math.floor(pointY * 10) / 10;
        return "(" + reX + "," + reY + ")";
    }
}
