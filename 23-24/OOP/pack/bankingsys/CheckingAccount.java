public class CheckingAccount extends Account {
    /**
     * ok.
     */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * ok.
     */
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /**
     * ok.
     */
    public void deposit(double amount) {
        try {
            doDepositing(amount);
        } catch (InvalidFundingAmountException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
