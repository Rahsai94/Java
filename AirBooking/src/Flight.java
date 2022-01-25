import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Flight {
    private int flightNumber;
    private Aircraft craft;
    private  String startLocation;
    private String endLocation;
    private double distance;

    public ArrayList<Seat> seats;
    public ArrayList<CrewMember> crew;

    public Flight(int flightNumber, Aircraft craft, String startLocation, String endLocation, double distance) {
        this.flightNumber = flightNumber;
        this.craft = craft;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
        this.seats = addSeats(craft.getLayoutFile());
        this.crew = new ArrayList<>();

    }

    // Populate the Seats
    private ArrayList<Seat> addSeats(File file) {


        ArrayList<Seat> temp = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new FileReader(file));

            int row = 1;

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String [] arr = line.split(",");
                System.out.println(Arrays.toString(arr) + arr.length);

                if(arr[0].equals("F")){
                    temp.add(new Seat(row, arr.length, "first"));
                }else {
                    temp.add(new Seat(row, arr.length, "economy"));
                }
                row++;
            }

        } catch (FileNotFoundException e){
            System.out.println("can't find layout file");
        }
        return temp;
    }

    public double calculateTakeOffWeight() {
        double totalWeight = 0;

        for(CrewMember crewMember: crew){
            totalWeight += crewMember.calculatePersonWeight();
        }
        for(Seat seat: seats){
            totalWeight += seat.getAllocatedTo().calculatePersonWeight();
        }

        if(totalWeight >= this.craft.getMaximumTakeoffWeight()){
            return -1;
        }

        return totalWeight;
    }


    public int bookSeat(Passenger passenger){
        int result = -1;

        for (int i = 0; i < seats.size(); i++) {
           if(seats.get(i).getFlyingClass().equals(passenger.getFlightClass()) && seats.get(i).getSeat() != 0){
                seats.get(i).setSeat(seats.get(i).getSeat() - 1);
                result = 1;
           }
        }

        if(passenger.getFlightClass().equals("first") && result == -1){
            for (int j = 0; j < seats.size(); j++) {
                if(seats.get(j).getSeat() != 0){
                    seats.get(j).setSeat(seats.get(j).getSeat() - 1);
                    result = 3;
                }
            }
        }

        if(passenger.getFlightClass().equals("economy") && result == -1){
            for (int k = 0; k < seats.size(); k++) {
                if(seats.get(k).getSeat() != 0){
                    seats.get(k).setSeat(seats.get(k).getSeat() - 1);
                    result = 2;
                }
            }
        }

        return result;
    }


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
}
