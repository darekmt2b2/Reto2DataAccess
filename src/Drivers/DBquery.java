package Drivers;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBquery {

//aircraft
    public static void allAircraft(int option) throws SQLException {
        Connection conexion = null;
        Statement statement = null;
        int id;
        String name;
        String series;
        String manufacturer;

        Scanner scan;
        String airlineName;

        switch (option){
            case 3:
                try {
                    conexion = DBcontrol.Connection(); //connection+login credentials

                    statement = conexion.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM aircraft");

                    while (rs.next()){
                        id = rs.getInt("id"); // Gets aircraft's id
                        name = rs.getString("Name"); // Gets the aircraft itself
                        series = rs.getString("Series"); // Aircraft series, a certain aircraft can have several variants
                        manufacturer = rs.getString("Manufacturer"); // Plane manufacturer

                        // Print the data
                        System.out.println("ID: " + id + "," + name + ", series: " + series+", manufacturer: "+manufacturer);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            case 2:

                try {

                    System.out.println("Which model would you like to check?");
                    scan= new Scanner(System.in);
                    airlineName= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials

                    statement = conexion.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM `aircraft` WHERE `Name` = '" + airlineName + "';");


                    while (rs.next()){
                        id = rs.getInt("id"); //
                        name = rs.getString("Name"); //
                        series = rs.getString("Series"); //
                        manufacturer = rs.getString("Manufacturer"); //

                        // Print the data
                        System.out.println("ID: " + id + "," + name + ", series: " + series+", manufacturer: "+manufacturer);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                    ex.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            case 1:
                try {

                    System.out.println("Which manufacturer would you like to check?");
                    scan= new Scanner(System.in);
                    airlineName= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials

                    statement = conexion.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM `aircraft` WHERE `Manufacturer` = '" + airlineName + "';");


                    while (rs.next()){
                        id = rs.getInt("id"); //
                        name = rs.getString("Name"); //
                        series = rs.getString("Series"); //
                        manufacturer = rs.getString("Manufacturer"); //

                        // Print the data
                        System.out.println("ID: " + id + "," + name + ", series: " + series+", manufacturer: "+manufacturer);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                    ex.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
               break;
            default: System.out.println("not an option");
        }

    }

    //Airline

    public static void allAirlines(int option) throws SQLException {
        Connection conexion = null;
        Statement statement = null;
        int id;
        String name;
        String country;
        String hub;
        String hubIATA;

        Scanner scan;
        String airlineData;

        switch (option){
            case 4:
                try {
                    conexion = DBcontrol.Connection(); //connection+login credentials

                    statement = conexion.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM airlinehubs");

                    while (rs.next()){
                        id = rs.getInt("ID"); // Gets aircraft's id
                        name = rs.getString("Name"); // Gets the aircraft itself
                        country = rs.getString("Country"); // Aircraft series, a certain aircraft can have several variants
                        hub = rs.getString("Hub"); // Plane manufacturer
                        hubIATA=rs.getString("IATA");

                        // Print the data
                        System.out.println("ID: " + id + "," + name + ", series: " + country+", hub:"+hub+", IATA: "+hubIATA);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            case 3:

                try {

                    System.out.println("Specify the name: ");
                    scan= new Scanner(System.in);
                    airlineData= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials

                    statement = conexion.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM `airlinehubs` WHERE `Name` = '" + airlineData + "';");


                    while (rs.next()){
                        id = rs.getInt("id"); //
                        name = rs.getString("Name"); //
                        country = rs.getString("Country"); //
                        hub = rs.getString("Hub"); //
                        hubIATA = rs.getString("IATA"); //

                        // Print the data
                        System.out.println("ID: " + id + "," + name + ", Country: " + country+", hub:"+hub+", IATA: "+hubIATA);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                    ex.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            case 2:
                try {

                    System.out.println("Specify the Hub: \n (be aware to introduce the exact IATA code ");
                    scan= new Scanner(System.in);
                    airlineData= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials

                    statement = conexion.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM `airlinehubs` WHERE `IATA` = '" + airlineData + "';");


                    while (rs.next()){
                        id = rs.getInt("id"); //
                        name = rs.getString("Name"); //
                        country = rs.getString("Country"); //
                        hub = rs.getString("Hub"); //
                        hubIATA = rs.getString("IATA"); //

                        // Print the data
                        System.out.println("ID: " + id + "," + name + ", Country: " + country+", Hub:"+hub+", IATA: "+hubIATA);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                    ex.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            case 1:
                try {

                    System.out.println("Specify the Country: ");
                    scan= new Scanner(System.in);
                    airlineData= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials

                    statement = conexion.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM `airlinehubs` WHERE `Country` = '" + airlineData + "';");

                    while (rs.next()){
                        id = rs.getInt("id"); //
                        name = rs.getString("Name"); //
                        country = rs.getString("Country"); //
                        hub = rs.getString("Hub"); //
                        hubIATA = rs.getString("IATA"); //

                        // Print the data
                        System.out.println("ID: " + id + "," + name + ", Country: " + country+", Hub:"+hub+", IATA: "+hubIATA);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            default: System.out.println("not an option");


        }

    }

    //airport
    public static void allAirports(int option) throws SQLException {
        Connection conexion = null;
        Statement statement = null;
        int id;
        String name;
        String city;
        String country;
        String continent;
        String IATA;

        Scanner scan;
        String airportData;

        switch (option){
            case 5:
                try {
                    conexion = DBcontrol.Connection(); //connection+login credentials

                    statement = conexion.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM airport");

                    while (rs.next()){
                        id = rs.getInt("ID"); //
                        name = rs.getString("Name"); //
                        city = rs.getString("City");
                        country = rs.getString("Country"); //
                        continent = rs.getString("Continent"); //
                        IATA=rs.getString("IATA");

                        // Print the data
                        System.out.println("ID: " + id + ", Name:" + name + ", city: " + city+", Country:"+country+", Continent: "+continent+",  IATA: "+IATA);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            case 4:

                try {

                    System.out.println("Specify the continent: ");
                    scan= new Scanner(System.in);
                    airportData= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials

                    statement = conexion.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM `airport` WHERE `Continent` = '" + airportData + "';");


                    while (rs.next()){
                        id = rs.getInt("ID"); //
                        name = rs.getString("Name"); //
                        city = rs.getString("City");
                        country = rs.getString("Country"); //
                        continent = rs.getString("Continent"); //
                        IATA=rs.getString("IATA");

                        // Print the data
                        System.out.println("ID: " + id + ", Name:" + name + ", city: " + city+", Country:"+country+", Continent: "+continent+",  IATA: "+IATA);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                    ex.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            case 3:
                try {

                    System.out.println("Specify the Country:");
                    scan= new Scanner(System.in);
                    airportData= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials
                    statement = conexion.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM `airport` WHERE `Country` = '" + airportData + "';");


                    while (rs.next()){
                        id = rs.getInt("ID"); //
                        name = rs.getString("Name"); //
                        city = rs.getString("City");
                        country = rs.getString("Country"); //
                        continent = rs.getString("Continent"); //
                        IATA=rs.getString("IATA");

                        // Print the data
                        System.out.println("ID: " + id + ", Name:" + name + ", city: " + city+", Country:"+country+", Continent: "+continent+",  IATA: "+IATA);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                    ex.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            case 2:
                try {

                    System.out.println("Specify the City: ");
                    scan= new Scanner(System.in);
                    airportData= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials
                    statement = conexion.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM `airport` WHERE `City` = '" + airportData + "';");;

                    while (rs.next()){
                        id = rs.getInt("ID"); //
                        name = rs.getString("Name"); //
                        city = rs.getString("City");
                        country = rs.getString("Country"); //
                        continent = rs.getString("Continent"); //
                        IATA=rs.getString("IATA");

                        // Print the data
                        System.out.println("ID: " + id + ", Name:" + name + ", city: " + city+", Country:"+country+", Continent: "+continent+",  IATA: "+IATA);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            case 1:
                try {

                    System.out.println("Specify the IATA: ");
                    scan= new Scanner(System.in);
                    airportData= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials
                    statement = conexion.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM `airport` WHERE `IATA` = '" + airportData + "';");;

                    while (rs.next()){
                        id = rs.getInt("ID"); //
                        name = rs.getString("Name"); //
                        city = rs.getString("City");
                        country = rs.getString("Country"); //
                        continent = rs.getString("Continent"); //
                        IATA=rs.getString("IATA");

                        // Print the data
                        System.out.println("ID: " + id + ", Name:" + name + ", city: " + city+", Country:"+country+", Continent: "+continent+",  IATA: "+IATA);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                } finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            default: System.out.println("not an option");
        }

    }

    //flights
    public static void allFlights(int option) throws SQLException {
        Connection conexion = null;
        Statement statement = null;
        int id;
        String departure;
        String arrival;
        String aircraft;
        String airline;
        String departureIATA;
        String arrivalIATA;

        Scanner scan;
        String flightDate;
        String flightDeparture;
        String flightArrival;

        switch (option) {
            case (5):
                try {
                    conexion = DBcontrol.Connection(); //connection+login credentials

                    statement = conexion.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM flightinfoview");

                    while (rs.next()) {
                        // Retrieve data from FlightInfoView
                        id = rs.getInt("FlightID");
                        departure = rs.getString("departureDate");
                        arrival = rs.getString("arrivalDate");
                        aircraft = rs.getString("AircraftName");
                        airline = rs.getString("AirlineName");
                        departureIATA = rs.getString("DepartureIATA");
                        arrivalIATA = rs.getString("ArrivalIATA");


                        System.out.println("Flight ID: " + id + ", Departure Date: " + departure + ", Arrival Date: " + arrival + ", Departure IATA: " + departureIATA + ", Arrival IATA: " + arrivalIATA + ", Aircraft Name: " + aircraft + ", Airline Name: " + airline);

                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;
            case (4):
                try {
                    System.out.println("Introduce the departure date (yyyy-mm-dd): ");
                    scan= new Scanner(System.in);
                    flightDeparture= scan.next();
                    System.out.println("Introduce the arrival date (yyyy-mm-dd): ");
                    flightArrival= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials
                    statement = conexion.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM flights WHERE departureDate BETWEEN '"+flightDeparture+"' AND '"+flightArrival+"';");

                    while (rs.next()) {
                        id = rs.getInt("ID"); //
                        departure = rs.getString("departureDate"); //
                        arrival = rs.getString("arrivalDate");
                        aircraft = rs.getString("aircraft"); //
                        airline = rs.getString("Airline");

                        // Print the data
                        System.out.println("ID: " + id + ", departure:" + departure + ", arrival: " + arrival + ", aircraft:" + aircraft + ", airline: " + airline);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                    ex.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }

                break;
            case (3):
                try {
                    System.out.println("Introduce the date (yyyy-mm-dd): ");
                    scan= new Scanner(System.in);
                    flightDate= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials
                    statement = conexion.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM flights WHERE departureDate = '"+flightDate+"' AND arrivalDate = '" + flightDate +"';");

                    while (rs.next()) {
                        id = rs.getInt("ID"); //
                        departure = rs.getString("departureDate"); //
                        arrival = rs.getString("arrivalDate");
                        aircraft = rs.getString("aircraft"); //
                        airline = rs.getString("Airline");

                        // Print the data
                        System.out.println("ID: " + id + ", departure:" + departure + ", arrival: " + arrival + ", aircraft:" + aircraft + ", airline: " + airline);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                    ex.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }

                break;
            case (2):
                try {
                    System.out.println("Introduce the date (yyyy-mm-dd): ");
                    scan= new Scanner(System.in);
                    flightDate= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials
                    statement = conexion.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM flights WHERE departureDate > '"+flightDate+"';");

                    while (rs.next()) {
                        id = rs.getInt("ID"); //
                        departure = rs.getString("departureDate"); //
                        arrival = rs.getString("arrivalDate");
                        aircraft = rs.getString("aircraft"); //
                        airline = rs.getString("Airline");

                        // Print the data
                        System.out.println("ID: " + id + ", departure:" + departure + ", arrival: " + arrival + ", aircraft:" + aircraft + ", airline: " + airline);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                    ex.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }

                break;
            case (1):
                try {
                    System.out.println("Introduce the date (yyyy-mm-dd): ");
                    scan= new Scanner(System.in);
                    flightDate= scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials
                    statement = conexion.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM flights WHERE departureDate < '"+flightDate+"';");

                    while (rs.next()) {
                        id = rs.getInt("ID"); //
                        departure = rs.getString("departureDate"); //
                        arrival = rs.getString("arrivalDate");
                        aircraft = rs.getString("aircraft"); //
                        airline = rs.getString("Airline");

                        // Print the data
                        System.out.println("ID: " + id + ", departure:" + departure + ", arrival: " + arrival + ", aircraft:" + aircraft + ", airline: " + airline);
                    }

                } catch (SQLException ex) {
                    System.out.println("Error");
                    ex.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }

                break;
            default: System.out.println("Not an option");
        }


    }


}








