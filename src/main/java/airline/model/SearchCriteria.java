package airline.model;

import java.util.Date;

public class SearchCriteria {
    private String source;
    private String destination;
    private int numberOfPassengers;

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    private String departureDate;

    public SearchCriteria() {
    }

    public SearchCriteria(String source, String destination, int numberOfPassengers,String departureDate) {
        this.source = source;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
        this.departureDate=departureDate;
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

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
