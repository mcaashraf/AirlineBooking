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
                .filter(searchBySource(searchCriteria))
                .filter(searchByDestination(searchCriteria))
                .filter(searchByPassengers(searchCriteria))
                .filter(searchByDepartureDate(searchCriteria))
                .collect(Collectors.toList());
    }

    public Predicate<Flight> searchByDepartureDate(SearchCriteria searchCriteria)
    {
       return IsDepartureDateSpecified(searchCriteria.getDepartureDate()) ? x -> x.getDepartureDate().equals(searchCriteria.getDepartureDate()): x -> true;
    }

    public Predicate<Flight> searchByPassengers(SearchCriteria searchCriteria) {
        return x -> x.getAvailableSeats() >= searchCriteria.getNumberOfPassengers();
    }

    public Predicate<Flight> searchByDestination(SearchCriteria searchCriteria) {
        return x -> x.getDestination().equals(searchCriteria.getDestination());
    }

    public Predicate<Flight> searchBySource(SearchCriteria searchCriteria) {
        return x -> x.getSource().equals(searchCriteria.getSource());
    }
    public boolean IsDepartureDateSpecified(String departureDate)
    {
        return departureDate.isEmpty()? false : true;

    }


}
