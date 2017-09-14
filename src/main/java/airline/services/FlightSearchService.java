package airline.services;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.model.TravelClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FlightSearchService {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirplaneRepository airplaneRepository;

    public List<Flight> searchFlights(SearchCriteria searchCriteria) {
        flightRepository = new FlightRepository();
        airplaneRepository=new AirplaneRepository();
        List<Flight> flightsList = flightRepository.getFlights();

        return flightsList.stream()
                .filter(searchBySource(searchCriteria))
                .filter(searchByDestination(searchCriteria))
                .filter(searchByPassengersForClassType(searchCriteria))
                .filter(searchByDepartureDate(searchCriteria))
                .collect(Collectors.toList());


    }

    public Predicate<Flight> searchByDepartureDate(SearchCriteria searchCriteria)
    {
        return IsDepartureDateSpecified(searchCriteria.getDepartureDate()) ? flight -> flight.getDepartureDate().equals(searchCriteria.getDepartureDate()): flight -> true;
    }



    public Predicate<Flight> searchByPassengersForClassType(SearchCriteria searchCriteria)
    {

        return flight -> flight.getAvailableSeatsByClass(TravelClass.valueOf(searchCriteria.getTravelClass())) >= searchCriteria.getNumberOfPassengers();

    }

    public Predicate<Flight> searchByDestination(SearchCriteria searchCriteria) {
        return flight -> flight.getDestination().equals(searchCriteria.getDestination());
    }

    public Predicate<Flight> searchBySource(SearchCriteria searchCriteria) {
        return flight -> flight.getSource().equals(searchCriteria.getSource());
    }
    public boolean IsDepartureDateSpecified(String departureDate)
    {
        return departureDate.isEmpty()? false : true;

    }


}