package airline.services;

import airline.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FlightRepository {

    private ArrayList<Flight> flights = new ArrayList<Flight>();
    Date departureDate = new Date();


    public ArrayList<Flight> getFlights() {
        Flight flight1 = new Flight("F1", "HYD", "BLR", 5, "2017-09-05");
        Flight flight2 = new Flight("F2", "HYD", "PUN", 10, "2017-09-05");
        Flight flight3 = new Flight("F3", "BLR", "PUN", 25, "2017-09-05");
        Flight flight4 = new Flight("F4", "HYD", "BLR", 2, "2017-09-05");

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        return flights;
    }
}
