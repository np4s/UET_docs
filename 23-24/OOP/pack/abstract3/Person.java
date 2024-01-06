import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    private List<Vehicle> vehicleList = new ArrayList<>();

    /**
     * ok.
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * ok.
     */
    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    /**
     * ok.
     */
    public void removeVehicle(String registrationNumber) {
        vehicleList.removeIf(vehicle -> 
            (vehicle.getRegistrationNumber().equals(registrationNumber)));
    }

    /**
     * ok.
     */
    public String getVehiclesInfo() {
        if (vehicleList.isEmpty()) {
            return name + " has no vehicle!";
        }
        String result = name + " has:\n";
        for (Vehicle vehicle : vehicleList) {
            result += "\n" + vehicle.getInfo();
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
