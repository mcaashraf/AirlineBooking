package airline.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Airplane {

    private List<Seat> seatsList;
    private String airPlaneName;


    public Airplane(String airPlaneName,List<Seat> seatsList)
    {

        this.airPlaneName = airPlaneName;
        this.seatsList=seatsList;
    }

    public String getAirPlaneName() {
        return airPlaneName;
    }

    public Seat getSeatsByClass(TravelClass travelClass)
    {
        return seatsList.stream()
                .filter((seat -> seat.getTravelClass().equals(travelClass)))
                .collect(Collectors.toList()).get(0);
    }

}
