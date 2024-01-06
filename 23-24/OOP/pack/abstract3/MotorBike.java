public class MotorBike extends Vehicle {
    private boolean hasSidecar;

    /**
     * ok.
     * 
     * @param brand              b
     * @param model              m
     * @param registrationNumber r
     * @param owner              o
     */
    public MotorBike(String brand, String model,
            String registrationNumber, Person owner, boolean hasSidecar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    /**
     * ok.
     */
    public String getInfo() {
        return "Motor Bike:"
                + "\n\tBrand: " + super.getBrand()
                + "\n\tModel: " + super.getModel()
                + "\n\tRegistration Number: " + super.getRegistrationNumber()
                + "\n\tHas Side Car: " + this.isHasSidecar()
                + "\n\tBelongs to "
                + super.getOwner().getName()
                + " - " + super.getOwner().getAddress();
    }
}
