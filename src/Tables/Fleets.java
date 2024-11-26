package Tables;

public class Fleets {
    private int id;
    private int airlineID;
    private int aircraftID;
    private int fleetNumber;

    public Fleets(int id, int airlineID, int aircraftID, int fleetNumber) {
        this.id = id;
        this.airlineID = airlineID;
        this.aircraftID = aircraftID;
        this.fleetNumber = fleetNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getFleetNumber() {
        return fleetNumber;
    }

    public void setFleetNumber(int fleetNumber) {
        this.fleetNumber = fleetNumber;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", airlineID=" + airlineID +
                ", aircraftID=" + aircraftID +
                ", fleetNumber=" + fleetNumber +
                '}';
    }
}
