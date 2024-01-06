import java.util.Objects;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
    }

    public double getSide() {
        return super.getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    /**
     * lk.
     */
    public boolean equals(Object o) {
        if (!(o instanceof Square)) {
            return false;
        }
        Square square = (Square) o;
        return square.getTopLeft().equals(this.topLeft)
                && Math.abs(square.getSide() - this.getSide()) <= 0.001;
    }

    public int hashCode() {
        return Objects.hash(this);
    }

    /**
     * lk.
     */
    public String toString() {
        String topLeft = super.getTopLeft().toString();
        double side = Math.floor(this.getSide() * 10) / 10;
        String color = super.getColor();
        boolean isFilled = super.isFilled();

        return "Square[topLeft=" + topLeft + ",side=" + side
                + ",color=" + color + ",filled=" + isFilled + "]";
    }
}
