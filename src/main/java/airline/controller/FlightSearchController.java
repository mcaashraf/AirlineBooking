package airline.controller;

import airline.model.City;
import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.services.CityRepository;
import airline.services.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.*;

/**
 * Created by rajashrk on 8/8/17.
 */

@Controller
public class FlightSearchController {

    @Autowired
    CityRepository cityRepository;
    @Autowired
    FlightSearchService flightSearchService;

    @RequestMapping(value = "/airlineTicketing", method = RequestMethod.GET)
    public String getCities(Model model) {
        cityRepository = new CityRepository();
        List<City> cities = cityRepository.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("searchCriteria", new SearchCriteria("HYD", "BLR",1,"05-09-2017"));
        return "FlightSearch";
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getFlights(@ModelAttribute(value = "searchCriteria")SearchCriteria searchCriteria, Model model) throws ParseException
    {
        System.out.println(searchCriteria.getDepartureDate());
        flightSearchService = new FlightSearchService();
        List<Flight> availableFlights = flightSearchService.search(searchCriteria);
        model.addAttribute("searchResults", availableFlights);
        return "flightsView";


    }
}
