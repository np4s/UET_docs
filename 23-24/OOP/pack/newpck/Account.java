package newpck;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * deposit.
     * 
     * @param amount deposit amount
     */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.printf("So tien ban nap vao khong hop le!%n");
        } else {
            balance += amount;
            Transaction newTransaction = new Transaction(Transaction.DEPOSIT, amount, balance);
            transitionList.add(newTransaction);
        }
    }

    /**
     * withdraw.
     * 
     * @param amount withdraw amount
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.printf("So tien ban rut ra khong hop le!%n");
        } else if (amount > this.balance) {
            System.out.printf("So tien ban rut vuot qua so du!%n");
        } else {
            balance -= amount;
            Transaction newTransaction = new Transaction(Transaction.WITHDRAW, amount, balance);
            transitionList.add(newTransaction);
        }
    }

    /**
     * adding new transaction.
     * 
     * @param amount    amount
     * @param operation operation
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else {
            System.out.printf("Yeu cau khong hop le!%n");
        }
    }

    /**
     * print all transaction.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            Transaction transaction = transitionList.get(i);
            String operation = transaction.getOperation();
            double amount = transaction.getAmount();
            double balance = transaction.getBalance();
            if (operation.equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich %d: Nap tien $%.2f." 
                + " So du luc nay: $%.2f.%n", i + 1, amount, balance);
            }
            if (operation.equals(Transaction.WITHDRAW)) {
                System.out.printf("Giao dich %d: Rut tien $%.2f." 
                + " So du luc nay: $%.2f.%n", i + 1, amount, balance);
            }
        }
    }
}
 