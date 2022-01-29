public abstract class Person {
    private String name;
    private int passportNumber;

    //Constructor for Person Class
    public Person(String name, int passportNumber){
        this.name = name;
        this.passportNumber = passportNumber;
    }

    // Abstract Method Declaration
    public abstract double calculatePersonWeight();

    // Getter and Setter Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
}
