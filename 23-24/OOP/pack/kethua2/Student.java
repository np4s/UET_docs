public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    /**
     * declare student.
     * 
     * @param name st name
     * @param address st address
     * @param program st program
     * @param year st year
     * @param fee st fee
     */
    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public double getFee() {
        return this.fee;
    }

    public String getProgram() {
        return this.program;
    }

    public int getYear() {
        return this.year;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * describe.
     * 
     * @return description
     */
    public String toString() {
        return "Student[" + super.toString() + ",program=" + getProgram()
                + ",year=" + getYear() + ",fee=" + getFee() + "]";
    }
}
