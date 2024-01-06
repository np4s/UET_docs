public class Person implements Comparable<Person> {
    protected String name;
    protected int age;
    protected String address;

    public Person() {

    }

    /**
     * ok.
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * ok.
     */
    public int compareTo(Person p) {
        if (this.getName().compareTo(p.getName()) == 0) {
            return this.getAge() - p.getAge();
        }
        return this.getName().compareTo(p.getName());
    }
}
