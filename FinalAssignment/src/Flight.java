import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Flight {
    //Flight class members
    private int  flightNumber;
    private Aircraft craft;
    private String startLocation;
    private String endLocation;
    private double distance;

    // Public Members of Flight Class
    ArrayList<Seat> seats = new ArrayList<>();
    ArrayList<CrewMember> crew = new ArrayList<>();

    private static int flightCount = 0;

    // Parameters Constructor
    public Flight(int flightNumber, Aircraft craft, String startLocation, String endLocation, double distance) {
        this.flightNumber = flightNumber;
        this.craft = craft;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;

        // Populate the seats using the Layout file from craft
        try{
            Scanner scanner = new Scanner(new FileReader(craft.getLayoutFile()));
            int row = 0;
            while (scanner.hasNextLine()){
                row++;
                String line = scanner.nextLine().trim();
                String[] seatsInRow = line.split(",");
                for (int i = 0; i < seatsInRow.length; i++) {
                    String flyClass = "";
                    if(seatsInRow[i].equals("F")) flyClass = "first";
                    if(seatsInRow[i].equals("E")) flyClass = "economy";
                    this.seats.add(new Seat(row,i+1, flyClass));
                }
            }
        }catch (FileNotFoundException ignored){ // handle the FileNotFoundException
            System.out.println("can't find layout file");
        }

    }

    // Getter and Setter Methods for Class members
    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Aircraft getCraft() {
        return craft;
    }

    public void setCraft(Aircraft craft) {
        this.craft = craft;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    // CalculateTakeOffWeight of Flight
    public double calculateTakeOffWeight(){
        double totalWeight = this.craft.getCraftWeight();

        for (Seat seat: this.seats) {
            if(seat.getAllocatedTo() != null) totalWeight += seat.getAllocatedTo().calculatePersonWeight();
        }

        for(CrewMember crewMember : this.crew){
            totalWeight += crewMember.calculatePersonWeight();
        }

        if(totalWeight > this.craft.getMaximumTakeoffWeight()){
            return -1;
        }

        return totalWeight;
    }

    // bookSeat of Passenger

    public int bookSeat(Passenger passenger){

        int result = -1;


        for (int i = 0; i < this.seats.size(); i++) {
            if(passenger.getFlightClass().equals(this.seats.get(i).getFlyingClass()) && this.seats.get(i).getAllocatedTo() == null){
                this.seats.get(i).setAllocatedTo(passenger);
                result = 1;
                break;
            }
        }

        for (int i = 0; i < this.seats.size(); i++) {
            if( result == -1 && passenger.getFlightClass().equals("economy") && this.seats.get(i).getAllocatedTo() == null){
                this.seats.get(i).setAllocatedTo(passenger);
                result = 2;
                break;
            }
        }

        for (int i = 0; i < this.seats.size(); i++) {

            if( result == -1 && passenger.getFlightClass().equals("first") && this.seats.get(i).getAllocatedTo() == null){
                this.seats.get(i).setAllocatedTo(passenger);
                result = 3;
                break;
            }

        }


        return result;

    }


    @Override
    public String toString(){

        int firstClassPassengers = 0;
        int economyClassPassengers = 0;
        int unallocatedSeats = 0;

        String crews = "";
        //calculated allocated seats for first class and economy class and unallocated seats
        for (int i = 0; i < this.seats.size(); i++) {
            if(this.seats.get(i).getFlyingClass().equals("first") && this.seats.get(i).getAllocatedTo() != null){
                firstClassPassengers++;
            }else if(this.seats.get(i).getFlyingClass().equals("economy") && this.seats.get(i).getAllocatedTo() != null){
                economyClassPassengers++;
            }else {
                unallocatedSeats++;
            }
        }
        // Gets the all crew names
        for (int i = 0; i < this.crew.size(); i++){
            crews += this.crew.get(i).getName()+", ";
        }

        flightCount++;
        return "\n-------------\n" +
                "* Flight #"+flightCount+" *\n" +
                "-------------\n" +
                "From: "+this.startLocation+"\n" +
                "To: "+this.endLocation+"\n" +
                "Distance: "+this.distance+"\n" +
                "First class passangers: "+firstClassPassengers+"\n" +
                "Economy passengers: "+economyClassPassengers+"\n" +
                "Unallocated seats: "+unallocatedSeats+"\n" +
                "crew: "+crews+"\n" + this.craft.toString();
    }
}
