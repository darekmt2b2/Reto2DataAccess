package Tables;

public class Flights {
    private int id;
    private String departureDate;
    private String arrivalDate;
    private int airlineID;
    private int aircraftID;

    public Flights(int id, String departureDate, String arrivalDate, int airlineID, int aircraftID) {
        this.id = id;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airlineID = airlineID;
        this.aircraftID = aircraftID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }

    public int getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", airlineID=" + airlineID +
                ", aircraftID=" + aircraftID +
                '}';
    }
}
