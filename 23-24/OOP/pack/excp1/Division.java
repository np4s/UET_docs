public class Division extends BinaryExpression {
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * ok.
     * 
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "(" + left.toString() + " / " + right.toString() + ")";
    }

    /**
     * ok.
     * 
     */
    @Override
    public double evaluate() {
        // TODO Auto-generated method stub
        if (right.evaluate() != 0) {
            return left.evaluate() / right.evaluate();
        } else {
            throw new ArithmeticException("Lỗi chia cho 0");
        }
    }
}
