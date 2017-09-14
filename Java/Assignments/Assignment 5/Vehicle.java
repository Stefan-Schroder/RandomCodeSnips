public class Vehicle {
    private int numPassengers;
    private String colour;

    Vehicle(int passengers, String colour) {
        this.numPassengers = passengers;
        this.colour = colour;
    }

    public String toString() {
        return colour + " " + numPassengers + " passengers";
    }
}
