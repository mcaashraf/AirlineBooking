package airline.model;

public class Airplane {

    public void Airplane(String airPlaneId, String airPlaneName, int totalCapacity)
    {
        this.airPlaneId = airPlaneId;
        this.airPlaneName = airPlaneName;
        this.totalCapacity = totalCapacity;
    }


    public String getAirPlaneId()
    {
        return airPlaneId;
    }

    public void setAirPlaneId(String airPlaneId) {
        this.airPlaneId = airPlaneId;
    }

    private String airPlaneId;

    public String getAirPlaneName() {
        return airPlaneName;
    }

    public void setAirPlaneName(String airPlaneName) {
        this.airPlaneName = airPlaneName;
    }

    private String airPlaneName;

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    private int totalCapacity;

}
