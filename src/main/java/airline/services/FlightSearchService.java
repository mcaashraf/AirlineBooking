package airline.services;

import airline.model.Flight;
import airline.model.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FlightSearchService {
    @Autowired
    FlightRepository flightRepository;


    public List<Flight> search(SearchCriteria searchCriteria) {
        flightRepository = new FlightRepository();
        List<Flight> flightsList = flightRepository.getFlights();

        return flightsList.stream()
                .filter(x -> x.getSource().equals(searchCriteria.getSource()))
                .filter(x -> x.getDestination().equals(searchCriteria.getDestination()))
                .filter(x -> x.getAvailableSeats() >= searchCriteria.getNumberOfPassengers())
                .filter(x-> IsDepartureDateSpecified(searchCriteria.getDepartureDate()))
                .filter(x -> x.getDepartureDate().equals(searchCriteria.getDepartureDate()))
                .collect(Collectors.toList());
    }
    public boolean IsDepartureDateSpecified(String departureDate)
    {
        return departureDate.isEmpty()? false : true;

    }


}
