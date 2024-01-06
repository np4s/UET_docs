public class Subtraction extends BinaryExpression {
    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * ok.
     * 
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "(" + left.toString() + " - " + right.toString() + ")";
    }

    /**
     * ok.
     * 
     */
    @Override
    public double evaluate() {
        // TODO Auto-generated method stub
        return left.evaluate() - right.evaluate();
    }
}
