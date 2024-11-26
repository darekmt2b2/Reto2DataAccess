package Menu;
import Tables.*;

import java.util.ArrayList;

public class ShowAll {

    public static void showALL(){

        ArrayList<Aircraft> aircraftList = Lists.getAircraft();
        ArrayList<Airlines> airlinesList = Lists.getAirlines();
        ArrayList<Airports> airportsList= Lists.getAirports();
        ArrayList<Fleets> fleetsList = Lists.getAirlineFleets();
        ArrayList<Flights> flightsList = Lists.getFlights();
        ArrayList<Routes> routesList = Lists.getRoutes();

        System.out.println("Aircraft:");
        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft.toString());
        }
        System.out.println("Airlines:");
        for (Airlines airline: airlinesList) {
            System.out.println(airline.toString());
        }
        System.out.println("Airports:");
        for (Airports airport : airportsList) {
            System.out.println(airport.toString());
        }
        System.out.println("Flights:");
        for (Flights flight : flightsList) {
            System.out.println(flight.toString());
        }
        System.out.println("Routes:");
        for (Routes route : routesList) {
            System.out.println(route.toString());
        }
        System.out.println("Fleet:");
        for (Fleets fleet : fleetsList) {
            System.out.println(fleet.toString());
        }


    }
}
//left join for debugging, problem seems to be on a null request from second flight's airline fleet