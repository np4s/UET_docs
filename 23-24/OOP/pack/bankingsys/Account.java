import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";

    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    public Account() {
    }

    /**
     * ok.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * ok.
     */
    public String getTransactionHistory() {
        StringBuilder res = new StringBuilder("Lịch sử giao dịch của tài khoản "
                + accountNumber + ":");
        for (Transaction transaction : transactionList) {
            res.append("\n" + transaction.getTransactionSummary());
        }
        return res.toString();
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * ok.
     */
    public abstract void withdraw(double amount);

    /**
     * ok.
     */
    public abstract void deposit(double amount);

    /**
     * ok.
     */
    public void doWithdrawing(double amount)
            throws InvalidFundingAmountException, InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }
        if (amount < 0 || (this instanceof SavingsAccount
                && (balance - amount < 5000 || amount > 1000))) {
            throw new InvalidFundingAmountException(amount);
        }
        Transaction transaction = new Transaction(this instanceof SavingsAccount ? 3 : 1,
                amount, balance, balance - amount);
        balance -= amount;
        addTransaction(transaction);
    }

    /**
     * ok.
     */
    public void doDepositing(double amount)
            throws InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        }
        Transaction transaction = new Transaction(this instanceof SavingsAccount ? 2 : 0,
                amount, balance, balance + amount);
        balance += amount;
        addTransaction(transaction);
    }

    /**
     * ok.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Account)) {
            return false;
        }
        Account acc = (Account) obj;
        return acc.getAccountNumber() == this.accountNumber;
    }
}
