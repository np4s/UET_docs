public class Car extends Vehicle {
    private int numberOfDoors;

    /**
     * ok.
     * 
     * @param brand              b
     * @param model              m
     * @param registrationNumber r
     * @param owner              o
     */
    public Car(String brand, String model,
            String registrationNumber, Person owner, int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * ok.
     */
    public String getInfo() {
        return "Car:"
                + "\n\tBrand: " + super.getBrand()
                + "\n\tModel: " + super.getModel()
                + "\n\tRegistration Number: " + super.getRegistrationNumber()
                + "\n\tNumber of Doors: " + this.getNumberOfDoors()
                + "\n\tBelongs to "
                + super.getOwner().getName()
                + " - " + super.getOwner().getAddress();
    }
}
