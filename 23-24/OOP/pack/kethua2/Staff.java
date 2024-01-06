class Staff extends Person {
    private String school;
    private double pay;

    /**
     * declare staff.
     * 
     * @param name staff name
     * @param address staff address
     * @param school staff school
     * @param pay staff pay
     */
    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public double getPay() {
        return this.pay;
    }

    public String getSchool() {
        return this.school;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * describe.
     * 
     * @return description
     */
    public String toString() {
        return "Staff[" + super.toString() + ",school=" + getSchool() + ",pay=" + getPay() + "]";
    }
}
