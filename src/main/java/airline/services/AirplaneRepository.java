package airline.services;

import airline.model.Airplane;
import airline.model.TravelClass;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class AirplaneRepository {


    HashMap<String,HashMap<TravelClass,Integer>> airPlanesList=new HashMap<String,HashMap<TravelClass,Integer>>();
    public AirplaneRepository()
    {
        HashMap<TravelClass,Integer> travelClassList=new HashMap<TravelClass, Integer>();
        travelClassList.put(TravelClass.Economy,195);
        travelClassList.put(TravelClass.Business,35);
        travelClassList.put(TravelClass.First,8);
        airPlanesList.put("Boeing777-200LR(77L)",travelClassList);

        HashMap<TravelClass,Integer> travelClassList2=new HashMap<TravelClass, Integer>();
        travelClassList2.put(TravelClass.Economy,144);
        travelClassList2.put(TravelClass.Business,0);
        travelClassList2.put(TravelClass.First,0);
        airPlanesList.put("AirBus-A319-V2",travelClassList2);

        HashMap<TravelClass,Integer> travelClassList3=new HashMap<TravelClass, Integer>();
        travelClassList3.put(TravelClass.Economy,152);
        travelClassList3.put(TravelClass.Business,20);
        travelClassList3.put(TravelClass.First,0);
        airPlanesList.put("AirBus-A321",travelClassList3);
    }

    public Airplane getAirplaneByName(String airplaneName)
    {

        HashMap<TravelClass,Integer> seats=( HashMap<TravelClass,Integer>)airPlanesList.get(airplaneName);
        Airplane airPlane=new Airplane(airplaneName,seats);
        return airPlane;
    }
}
