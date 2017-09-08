package airline.model;

public class Seat {
    private TravelClass travelClass;
    private  double price;
    private int totalSeats;
    private int availableSeats;

    public Seat(TravelClass travelClass, double price, int totalSeats, int availableSeats) {
        this.travelClass = travelClass;
        this.price = price;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public double getPrice() {
        return price;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
