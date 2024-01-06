public class Numeral extends Expression {
    private double value;

    public Numeral() {
    }

    /**
     * ok.
     * 
     */
    public Numeral(double value) {
        this.value = value;
    }

    /**
     * ok.
     * 
     */
    public String toString() {
        return String.format("%.0f", value);
    }

    /**
     * ok.
     * 
     */
    public double evaluate() {
        return this.value;
    }
}
