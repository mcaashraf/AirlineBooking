package airline.model;
import airline.services.AirplaneRepository;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.time.DayOfWeek;

public class Flight {

    private String flightNumber;
    private String source;
    private String destination;
    private String departureDate;
    private Airplane airplane;
    private DayOfWeek[] businessSpecificDays = new DayOfWeek[] {DayOfWeek.MONDAY, DayOfWeek.FRIDAY, DayOfWeek.SUNDAY};



    AirplaneRepository airplaneRepository = new AirplaneRepository();

    public String getDepartureDate() {
        return departureDate;
    }

    public Flight() {
    }

    public Flight(String flightNumber, String source, String destination, String departureDate, String airplaneName) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.airplane = airplaneRepository.getAirplaneByName(airplaneName);

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
        this.destination = destination;    }

    public int getAvailableSeatsByClass(TravelClass travelClass) {

        return airplane.getSeatsByClass(travelClass).getAvailableSeats();

    }
    public int getTotalSeatsByClass(TravelClass travelClass) {
        return airplane.getSeatsByClass(travelClass).getTotalSeats();
    }

    public double getPriceByClass(TravelClass travelClass) {
        return airplane.getSeatsByClass(travelClass).getPrice();
    }


    public String getAirPlaneName() {
        return airplane.getAirPlaneName();
    }

    public int getSeatsByClass(String travelClass) {
        return getAvailableSeatsByClass(TravelClass.valueOf(travelClass));
    }

    public boolean isFlightOnBusinessSpecificDays(){
        return Arrays.asList(businessSpecificDays).contains(ConvertDate(departureDate).getDayOfWeek());
    }
    public LocalDate ConvertDate(String departureDate)
    {
        LocalDate localDate = LocalDate.parse(departureDate);
        return localDate;
    }

}
