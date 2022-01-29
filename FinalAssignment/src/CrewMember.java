public class CrewMember extends Person{
    // Parameter Constructor for Person
    public CrewMember(String name, int passportNumber) {
        super(name, passportNumber);
    }

    // Implementation of abstract method from parent class
    @Override
    public double calculatePersonWeight() {
        return 75.00;
    }

}
