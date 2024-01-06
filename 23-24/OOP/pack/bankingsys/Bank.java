import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * ok.
     */
    public void readCustomerList(InputStream inputStream) {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));

            String line;
            Customer customer = new Customer();
            while ((line = reader.readLine()) != null) {
                if (Character.isAlphabetic(line.charAt(0))) {
                    int splitPos = line.lastIndexOf(" ");
                    String name = line.substring(0, splitPos);
                    long id = Long.parseLong(line.substring(splitPos + 1, line.length()));

                    customer = new Customer(id, name);
                    customerList.add(customer);
                } else {
                    String[] info = line.split(" ");
                    if (info[1].equals(Account.CHECKING)) {
                        customer.addAccount(new CheckingAccount(Long.parseLong(info[0]),
                                Double.parseDouble(info[2])));
                    } else {
                        customer.addAccount(new SavingsAccount(Long.parseLong(info[0]),
                                Double.parseDouble(info[2])));
                    }
                }
            }

            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ok.
     */
    public String getCustomersInfoByIdOrder() {
        customerList.sort(Comparator.comparingLong(Customer::getIdNumber));
        StringBuilder res = new StringBuilder();
        customerList.forEach(customer -> res.append(customer.getCustomerInfo() + "\n"));
        return res.toString();
    }

    /**
     * ok.
     */
    public String getCustomersInfoByNameOrder() {
        for (int i = 0; i < customerList.size(); i++) {
            for (int j = i + 1; j < customerList.size(); j++) {
                Customer customerA = customerList.get(i);
                Customer customerB = customerList.get(j);
                if (customerA.getFullName().compareTo(customerB.getFullName()) > 0) {
                    customerList.set(i, customerB);
                    customerList.set(j, customerA);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        customerList.forEach(customer -> res.append(customer.getCustomerInfo() + "\n"));
        return res.toString();
    }
}