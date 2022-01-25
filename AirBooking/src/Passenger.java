//Passenger Class inherit from Person
public class Passenger extends Person{

    //Private instance variables of Passenger
    private int holdBags;
    private String flightClass;

    public Passenger(String name, int passportNumber, String flightClass, int holdBags) {
        super(name, passportNumber);
        this.flightClass = flightClass;
        this.holdBags = holdBags;
    }

    // Implement Abstract Method
    @Override
    public double calculatePersonWeight() {
       if(this.flightClass.equals("first")){
           return 87.5;
       }else {
           return 80.0;
       }
    }

    // Create Getter setter Methods
    public int getHoldBags() {
        return holdBags;
    }

    public void setHoldBags(int holdBags) {
        this.holdBags = holdBags;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }
}
