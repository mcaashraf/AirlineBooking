package airline.model;
import airline.services.AirplaneRepository;

public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private String  departureDate;
    private Airplane airplane;


    AirplaneRepository airplaneRepository = new AirplaneRepository();

    public String getDepartureDate() {
        return departureDate;
    }

    public Flight() {  }
    public Flight(String flightNumber, String source, String destination,String departureDate, String airplaneName) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureDate=departureDate;
        this.airplane= airplaneRepository.getAirplaneByName(airplaneName);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;

    }

    public int getSeatsByClass(TravelClass travelClass)
    {
        return airplane.getSeatsByClass(travelClass).getAvailableSeats();
    }

    public double getPriceByClass(TravelClass travelClass)
    {
        return airplane.getSeatsByClass(travelClass).getPrice();
    }

    public double getTotalCostOfBooking(String travelClass,int numberOfPassengers)
    {

        return (getPriceByClass(TravelClass.valueOf(travelClass)) * numberOfPassengers);
    }
    public String getAirPlaneName() {
        return airplane.getAirPlaneName();
    }

    public int getSeatsByClass(String travelClass){
        return getSeatsByClass(TravelClass.valueOf(travelClass));
    }
}
