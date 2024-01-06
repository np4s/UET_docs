public class Square extends Expression {
    private Expression expression;

    public Square() {
    }

    public Square(Expression expression) {
        this.expression = expression;
    }

    /**
     * ok.
     * 
     */
    public String toString() {
        return "(" + expression.toString() + ") ^ 2";
    }

    /**
     * ok.
     * 
     */
    public double evaluate() {
        return expression.evaluate() * expression.evaluate();
    }
}
