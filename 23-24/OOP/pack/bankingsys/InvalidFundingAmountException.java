public class InvalidFundingAmountException extends BankException {
    /**
     * ok.
     */
    public InvalidFundingAmountException(double amount) {
        super(String.format("Số tiền không hợp lệ: $%.2f", amount));
    }
}
