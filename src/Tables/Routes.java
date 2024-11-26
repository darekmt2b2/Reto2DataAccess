package Tables;

public class Routes {

    private int departureAirport;
    private int arrivalAirport;
    private int flightID;

    public Routes(int departureAirport, int arrivalAirport, int flightID) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightID = flightID;
    }

    public int getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(int departureAirport) {
        this.departureAirport = departureAirport;
    }

    public int getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(int arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", flightID=" + flightID +
                '}';
    }
}
