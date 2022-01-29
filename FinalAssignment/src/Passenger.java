public class Passenger extends Person {

    // private instance variables for Passenger
    private int holdBags;
    private String flightClass;

    // Constructor for the Passenger Class
    public Passenger(String name, int passportNumber, String fClass,  int bags) {
        super(name, passportNumber);
        this.holdBags = bags;
        this.flightClass = fClass;
    }

    // Abstract Method Implementation
    @Override
    public double calculatePersonWeight() {
        double weight;

        if(this.flightClass.equals("first"))
            weight = 87.5 + (this.holdBags * 25);
        else
            weight = 80.0 + (this.holdBags * 25);

        return weight;
    }

    // Getter and Setter Methods for Passenger


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
