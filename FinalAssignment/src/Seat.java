public class Seat {
    // private members of Seat class
    private int row;
    private int seat; // (location in the row)
    private String flyingClass;
    private Passenger allocatedTo;

    // Parameter Constructor
    public Seat(int row, int seat, String flyingClass) {
        this.row = row;
        this.seat = seat;
        this.flyingClass = flyingClass;
    }

    // Getter and Setter Methods for class members
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getFlyingClass() {
        return flyingClass;
    }

    public void setFlyingClass(String flyingClass) {
        this.flyingClass = flyingClass;
    }

    public Passenger getAllocatedTo() {
        return allocatedTo;
    }

    public void setAllocatedTo(Passenger allocatedTo) {
        this.allocatedTo = allocatedTo;
    }

    // Override the toString methods
    @Override
    public String toString() {
        return "--------\n Seat -------\n" +
                "row=" + this.row +
                ", seat=" + this.seat +
                ", flyingClass='" + this.flyingClass + '\'' +
                ", allocatedTo=" + this.allocatedTo +
                "\n----------------------------";
    }
}
