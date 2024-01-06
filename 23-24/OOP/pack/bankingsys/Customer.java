import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    public Customer() {
    }

    /**
     * ok.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * ok.
     */
    public String getCustomerInfo() {
        return String.format("Số CMND: %d. Họ tên: " + fullName + ".", idNumber);
    }

    /**
     * ok.
     */
    public void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * ok.
     */
    public void removeAccount(Account account) {
        accountList.removeIf(acc -> acc.equals(account));
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public String getFullName() {
        return fullName;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }
}
