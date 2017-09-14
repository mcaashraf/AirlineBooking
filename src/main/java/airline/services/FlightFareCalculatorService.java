package airline.services;
import airline.model.Flight;
import airline.model.TravelClass;
import org.springframework.stereotype.Service;


@Service
public class FlightFareCalculatorService {

        public double getTotalCostOfBooking(Flight flight,String travelClass,int numberOfPassengers) {
        switch (travelClass){
            case "Economy":
                return getFlightFareForEconomyClass(flight,numberOfPassengers);
            case "Business":
                return getFlightFareForBusinessClass(flight,numberOfPassengers);
            case "First":
                return getFlightFareForFirstClass(flight,numberOfPassengers);
            default:
                return 0;
        }
    }

    public double getFlightFareForEconomyClass(Flight flight,int numberOfPassengers)
    {
        double seatPrice = flight.getPriceByClass(TravelClass.Economy);
        int availableSeats = flight.getAvailableSeatsByClass(TravelClass.Economy);
        int totalSeats = flight.getTotalSeatsByClass(TravelClass.Economy);
        double totalSeatPrice = 0;

        if (availableSeats == 0.4 * (totalSeats)) {
            totalSeatPrice = (seatPrice * numberOfPassengers);
        } else if ((availableSeats >= 0.4 * (totalSeats)) && (availableSeats <= 0.9 * (totalSeats))) {
            totalSeatPrice = ((seatPrice + (seatPrice * 0.3)) * numberOfPassengers);
        } else if (availableSeats <= 0.1 * (totalSeats)) {
            totalSeatPrice = ((seatPrice + (seatPrice * 0.6)) * numberOfPassengers);
        }

        return totalSeatPrice;
    }

    public double getFlightFareForBusinessClass(Flight flight,int numberOfPassengers)
    {
        double seatPrice = flight.getPriceByClass(TravelClass.Business);
        return (flight.isFlightOnBusinessSpecificDays() ? seatPrice+(seatPrice*0.4): seatPrice) * numberOfPassengers;
    }

    public double getFlightFareForFirstClass(Flight flight,int numberOfPassengers)
    {
      return flight.getPriceByClass(TravelClass.First) * numberOfPassengers;
    }
}
