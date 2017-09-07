package airline.services;

import airline.model.Flight;
import airline.model.TravelClass;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class FlightRepository {

    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public ArrayList<Flight> getFlights() {
        Flight flight1 = new Flight("F1", "HYD", "BLR",  LocalDate.now().toString(),"Boeing777-200LR(77L)");
        Flight flight2 = new Flight("F2", "HYD", "PUN", LocalDate.now().plusDays(1).toString(),"AirBus-A319-V2");
        Flight flight3 = new Flight("F3", "BLR", "PUN",  LocalDate.now().plusDays(3).toString(),"Boeing777-200LR(77L)");
        Flight flight4 = new Flight("F4", "HYD", "BLR", LocalDate.now().plusDays(15).toString(),"AirBus-A321");

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        return flights;
    }

  public  List<TravelClass> getTravelTypes= Arrays.asList(TravelClass.values());
}
