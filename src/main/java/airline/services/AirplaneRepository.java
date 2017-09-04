package airline.services;
import airline.model.Airplane;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AirplaneRepository {

    public List<Airplane> getCities() {
        List<Airplane> airplanes = new ArrayList<>();
       // airplanes.add();
//      airplanes.add(new Airplane("HYD", "Hyderabad"));
//        airplanes.add(new Airplane("BLR", "Bengaluru"));
//        airplanes.add(new City("PUN", "Pune"));
        return airplanes;
    }


  //  public List<Airplane> getAirplanes() {

      /*  List<Airplane> airplaneList = new ArrayList<Airplane>();
        airplaneList.add(new Airplane("A1","A380",70));
        airplaneList.add(new Airplane("BLR", "Bengaluru"));
        airplaneList.add(new Airplane("PUN", "Pune"));
        return airplaneList;*/
   // }
}
