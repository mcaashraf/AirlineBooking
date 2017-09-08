package airline.services;

import airline.model.Airplane;
import airline.model.Seat;
import airline.model.TravelClass;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class AirplaneRepository {


    HashMap<String,List<Seat>> airPlanesList=new HashMap<String,List<Seat>>();
    public AirplaneRepository()
    {
        List<Seat> boeingSeatsF1 = new ArrayList<Seat>();
        boeingSeatsF1.add(new Seat(TravelClass.Economy,6000,195,195));
        boeingSeatsF1.add(new Seat(TravelClass.Business,13000,35,35));
        boeingSeatsF1.add( new Seat(TravelClass.First,20000,8,8));
        airPlanesList.put("Boeing777-200LR(77L)",boeingSeatsF1);
        List<Seat> boeingSeatsF2 = new ArrayList<Seat>();
        boeingSeatsF2.add(new Seat(TravelClass.Economy,4000,144,144));
        boeingSeatsF2.add(new Seat(TravelClass.Business,0,0,0));
        boeingSeatsF2.add( new Seat(TravelClass.First,0,0,0));
        airPlanesList.put("AirBus-A319-V2",boeingSeatsF2);
        List<Seat> boeingSeatsF3 = new ArrayList<Seat>();
        boeingSeatsF3.add(new Seat(TravelClass.Economy,4000,152,152));
        boeingSeatsF3.add(new Seat(TravelClass.Business,0,20,20));
        boeingSeatsF3.add( new Seat(TravelClass.First,0,0,0));
        airPlanesList.put("AirBus-A321",boeingSeatsF3);
    }

    public Airplane getAirplaneByName(String airplaneName)
    {

       List<Seat> seats= airPlanesList.get(airplaneName);
        Airplane airPlane=new Airplane(airplaneName,seats);
        return airPlane;
    }
}
