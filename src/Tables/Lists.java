package Tables;

import Drivers.DBcontrol;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Lists {

    public static ArrayList<Airlines> getAirlines(){
        ArrayList<Airlines> airlines = new ArrayList<>();
        Connection connection=null;
        Statement statement=null;

        try {
            connection = DBcontrol.Connection();
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM airline");

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String country = rs.getString("Country");
                int hub = rs.getInt("Hub");
                airlines.add(new Airlines(id, name, country, hub));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBcontrol.disconnect(connection,statement);
        }
        return airlines;
    }

    public static ArrayList<Airports> getAirports() {
        ArrayList<Airports> airports = new ArrayList<>();
        Connection connection=null;
        Statement statement=null;

        try {
            connection = DBcontrol.Connection();
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT ID, Name, City, Country, IATA, Continent FROM airport");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String city = rs.getString("City");
                String country = rs.getString("Country");
                String iata = rs.getString("IATA");
                String continent = rs.getString("Continent");
                airports.add(new Airports(id, name, city, country, iata, continent));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBcontrol.disconnect(connection,statement);
        }
        return airports;
    }

    public static ArrayList<Fleets> getAirlineFleets() {
        ArrayList<Fleets> airlineFleets = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBcontrol.Connection();
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT ID, PlaneID, fleet, AirlineID FROM airlinefleets");
            while (rs.next()) {
                int id = rs.getInt("ID");
                int planeId = rs.getInt("PlaneID");
                int fleet = rs.getInt("fleet");
                int airlineId = rs.getInt("AirlineID");
                airlineFleets.add(new Fleets(id, planeId, fleet, airlineId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBcontrol.disconnect(connection, statement);
        }
        return airlineFleets;
    }

    public static ArrayList<Flights> getFlights() {
        ArrayList<Flights> flights = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBcontrol.Connection();
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT ID, departureDate, arrivalDate, aircraft, Airline FROM flights");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String departureDate = rs.getString("departureDate");
                String arrivalDate = rs.getString("arrivalDate");
                int aircraft = rs.getInt("aircraft");
                int airline = rs.getInt("Airline");
                flights.add(new Flights(id, departureDate, arrivalDate, aircraft, airline));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBcontrol.disconnect(connection, statement);
        }
        return flights;
    }

    public static ArrayList<Aircraft> getAircraft() {
        ArrayList<Aircraft> aircraft = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBcontrol.Connection();
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT ID, Name, Series, Manufacturer FROM aircraft");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String series = rs.getString("Series");
                String manufacturer = rs.getString("Manufacturer");
                aircraft.add(new Aircraft(id, name, series, manufacturer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBcontrol.disconnect(connection, statement);
        }
        return aircraft;
    }

    public static ArrayList<Routes> getRoutes() {
        ArrayList<Routes> routes = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBcontrol.Connection();
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT departureID, arrivalID, flightID FROM route");
            while (rs.next()) {
                int departureId = rs.getInt("departureID");
                int arrivalId = rs.getInt("arrivalID");
                int flightId = rs.getInt("flightID");
                routes.add(new Routes(departureId, arrivalId, flightId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBcontrol.disconnect(connection, statement);
        }
        return routes;
    }




}
