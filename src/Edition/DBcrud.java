package Edition;

import Drivers.DBcontrol;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBcrud {

    public static void aircraft(int option) throws SQLException {
        Connection conexion = null;
        Statement statement = null;
        String Name;
        String Series;
        String Manufacturer;

        int ID;
        Scanner scan;
        int rs;

        switch (option){
            case 1:
                try {

                    scan=new Scanner(System.in);
                    System.out.println("Introduce Aircraft name:");
                    Name = scan.next();
                    System.out.println("Series:");
                    Series = scan.next();
                    System.out.println("Manufacturer:");
                    Manufacturer = scan.next();

                    conexion = DBcontrol.Connection(); //connection+login credentials
                    statement = conexion.createStatement();

                    rs = statement.executeUpdate("INSERT INTO aircraft(Name,Series,Manufacturer) VALUES ('"+Name+"','"+Series+"','"+Manufacturer+"');");
                    System.out.println(rs);
                }catch (SQLException e){
                    System.out.println("Error");
                    e.getErrorCode();
                }finally {
                    DBcontrol.disconnect(conexion,statement);
                }
                break;
            case 2:
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter the Aircraft ID to update:");
                    ID = scan.nextInt(); // Get the ID of the aircraft to update
                    System.out.println("Introduce new Aircraft Name:");
                    Name = scan.next();
                    System.out.println("New Series:");
                    Series = scan.next();
                    System.out.println("New Manufacturer:");
                    Manufacturer = scan.next();

                    conexion = DBcontrol.Connection(); // Connection + login credentials
                    statement = conexion.createStatement();

                    // Update the aircraft table
                    rs = statement.executeUpdate("UPDATE aircraft SET Name = '" + Name + "', Series = '" + Series + "', Manufacturer = '" + Manufacturer + "' WHERE ID = " + ID + ";");

                    System.out.println(rs);
                } catch (SQLException e) {
                    System.out.println("Error during update");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;
            case 3:
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter the Aircraft ID to delete:");
                    ID = scan.nextInt(); // Get the ID of the aircraft to delete

                    conexion = DBcontrol.Connection(); // Connection + login credentials
                    statement = conexion.createStatement();

                    // Remove references of this aircraft in flights,NULL set
                    System.out.println("Removing references to this aircraft in flights...");
                    rs = statement.executeUpdate("UPDATE flights SET aircraft = NULL WHERE aircraft = " + ID + ";");
                    System.out.println("References removed in flights: " + rs);

                    // Deletes instances of fleets with this aircraft
                    System.out.println("Deleting references to this aircraft in airlinefleets...");
                    rs = statement.executeUpdate("DELETE FROM airlinefleets WHERE PlaneID = " + ID + ";");
                    System.out.println("References removed in airlinefleets: " + rs);

                    // Delete the aircraft itself
                    System.out.println("Deleting the aircraft...");
                    rs = statement.executeUpdate("DELETE FROM aircraft WHERE ID = " + ID + ";");
                    System.out.println("Rows deleted in aircraft: " + rs);
                } catch (SQLException e) {
                    System.out.println("Error during deletion");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;
            default: System.out.println("not an option");

        }

    }
    public static void airline(int option) throws SQLException {
        Connection conexion = null;
        Statement statement = null;
        String Name, Country;
        int Hub;
        int ID;
        Scanner scan;

        int rs;

        switch (option) {
            case 1: // Insert
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter Airline Name:");
                    Name = scan.next();
                    System.out.println("Enter Country:");
                    Country = scan.next();
                    System.out.println("Enter Hub Airport ID:");
                    Hub = scan.nextInt();

                    conexion = DBcontrol.Connection(); // connection + login credentials
                    statement = conexion.createStatement();

                    rs = statement.executeUpdate("INSERT INTO airline(Name, Country, Hub) VALUES ('" + Name + "', '" + Country + "', " + Hub + ");");
                    System.out.println(rs);
                } catch (SQLException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            case 2: // Update
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter Airline ID :");
                    ID = scan.nextInt();
                    System.out.println("Enter new Airline Name:");
                    Name = scan.next();
                    System.out.println("Enter new Country:");
                    Country = scan.next();
                    System.out.println("Enter new Hub Airport ID:");
                    Hub = scan.nextInt();

                    conexion = DBcontrol.Connection();
                    statement = conexion.createStatement();

                    rs = statement.executeUpdate("UPDATE airline SET Name = '" + Name + "', Country = '" + Country + "', Hub = " + Hub + " WHERE ID = " + ID + ";");
                    System.out.println(rs);
                } catch (SQLException e) {
                    System.out.println("Error during update");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            case 3: // Delete
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter Airline ID to delete:");
                    ID = scan.nextInt();

                    conexion = DBcontrol.Connection();
                    statement = conexion.createStatement();

                    // Remove airline references in flights
                    System.out.println("Removing references to this airline in flights...");
                    rs = statement.executeUpdate("UPDATE flights SET Airline = NULL WHERE Airline = " + ID + ";");
                    System.out.println("References removed in flights: " + rs);

                    // Remove airline references in airlinefleets
                    System.out.println("Deleting references to this airline in airlinefleets...");
                    rs = statement.executeUpdate("DELETE FROM airlinefleets WHERE AirlineID = " + ID + ";");
                    System.out.println("References removed in airlinefleets: " + rs);

                    // Delete the airline itself
                    System.out.println("Deleting the airline...");
                    rs = statement.executeUpdate("DELETE FROM airline WHERE ID = " + ID + ";");
                    System.out.println("Rows deleted in airline: " + rs);
                } catch (SQLException e) {
                    System.out.println("Error during deletion");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            default: System.out.println("Not an option");
        }
    }
    public static void flights(int option) throws SQLException {
        Connection conexion = null;
        Statement statement = null;

        int departureID;
        int arrivalID;
        int aircraftID;
        int airlineID;

        String departureDate;
        String arrivalDate;
        int flightID;

        Scanner scan;

        int rs;

        switch (option) {
            case 1: // Insert
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter Airline ID:");
                    airlineID = scan.nextInt();
                    System.out.println("Enter Aircraft ID:");
                    aircraftID = scan.nextInt();
                    System.out.println("Enter departure Date(YYYY-MM-DD):");
                    departureDate = scan.next();
                    System.out.println("Enter departure Airport ID:");
                    departureID = scan.nextInt();
                    System.out.println("Enter arrival Date(YYYY-MM-DD):");
                    arrivalDate = scan.next();
                    System.out.println("Enter arrival Airport ID:");
                    arrivalID = scan.nextInt();

                    conexion = DBcontrol.Connection(); // connection + login credentials
                    statement = conexion.createStatement();

                    rs = statement.executeUpdate("INSERT INTO flights(departureDate, arrivalDate, aircraft, airline) VALUES ('" + departureDate + "', '" +arrivalDate+ "', " + aircraftID+","+airlineID+");");
                    System.out.println(rs);
                    ResultSet rsq = statement.executeQuery("SELECT LAST_INSERT_ID();");
                    flightID = rsq.getInt("ID");

                    rs = statement.executeUpdate("INSERT INTO route(departureID, arrivalID, flightID) VALUES (" + departureID+ "," +arrivalID+ ", " +flightID+");");
                    System.out.println(rs);
                } catch (SQLException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            case 2: // Update
                try {
                    scan = new Scanner(System.in);

                    System.out.println("ID of the register to be modified:");
                    flightID= scan.nextInt();

                    System.out.println("Enter Airline ID:");
                    airlineID = scan.nextInt();
                    System.out.println("Enter new Aircraft ID:");
                    aircraftID = scan.nextInt();
                    System.out.println("Enter new departure Date(YYYY-MM-DD):");
                    departureDate = scan.next();
                    System.out.println("Enter new departure Airport ID:");
                    departureID = scan.nextInt();
                    System.out.println("Enter new arrival Date(YYYY-MM-DD):");
                    arrivalDate = scan.next();
                    System.out.println("Enter new arrival Airport ID:");
                    arrivalID = scan.nextInt();

                    conexion = DBcontrol.Connection();
                    statement = conexion.createStatement();

                    rs = statement.executeUpdate("UPDATE flights SET departureDate = '" + departureDate + "', " + "arrivalDate = '" + arrivalDate + "', " + "aircraft = " + aircraftID + ", " + "airline = " + airlineID + " " + "WHERE flightID = " + flightID + ";");
                    System.out.println(rs);

                    rs = statement.executeUpdate("UPDATE route SET departureID = " + departureID + ", " + "arrivalID = " + arrivalID + ", " + "flightID = " + flightID + " " + "WHERE ID = " + flightID + ";");
                    System.out.println(rs);
                } catch (SQLException e) {
                    System.out.println("Error during update");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            case 3: // Delete
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter flight ID to delete:");
                    flightID = scan.nextInt();

                    conexion = DBcontrol.Connection();
                    statement = conexion.createStatement();

                    // Remove flight references in routes
                    System.out.println("Deleting references to this flight in routes...");
                    rs = statement.executeUpdate("DELETE FROM route WHERE flightID = " + flightID + ";");
                    System.out.println("References removed in airlinefleets: " + rs);

                    // Remove the flights itself
                    System.out.println("Removing flight...");
                    rs = statement.executeUpdate("DELETE FROM flights WHERE ID = " + flightID + ";");
                    System.out.println("References removed in flights: " + rs);

                } catch (SQLException e) {
                    System.out.println("Error during deletion");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            default: System.out.println("Not an option");
        }
    }

    public static void airports(int option) throws SQLException {
        Connection conexion = null;
        Statement statement = null;

        int ID;
        String name;
        String IATA;
        String city;
        String country;
        String continent;


        Scanner scan;

        int rs;

        switch (option) {
            case 1: // Insert
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter Airport name:");
                    name = scan.next();
                    System.out.println("Enter IATA code:");
                    IATA = scan.next();
                    System.out.println("Enter country");
                    city = scan.next();
                    System.out.println("Enter country");
                    country = scan.next();
                    System.out.println("Enter continent");
                    continent = scan.next();

                    conexion = DBcontrol.Connection(); // connection + login credentials
                    statement = conexion.createStatement();

                    rs = statement.executeUpdate("INSERT INTO airports(Name, city, country, IATA, continent) VALUES ('" + name + "', '" +city+ "', '" + country+"','"+IATA+"','"+continent+"');");
                    System.out.println(rs);

                } catch (SQLException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            case 2: // Update
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter airport ID to be modified:");
                    ID= scan.nextInt();

                    System.out.println("Enter new Airport name:");
                    name = scan.next();
                    System.out.println("Enter new IATA code:");
                    IATA = scan.next();
                    System.out.println("Enter new country");
                    city = scan.next();
                    System.out.println("Enter new country");
                    country = scan.next();
                    System.out.println("Enter new continent");
                    continent = scan.next();

                    conexion = DBcontrol.Connection();
                    statement = conexion.createStatement();

                    rs=statement.executeUpdate("UPDATE airports SET Name = '" + name + "', city = '" + city + "', country = '" + country + "', IATA = '" + IATA + "', continent = '" + continent + "' WHERE ID = " + ID + ";");
                } catch (SQLException e) {
                    System.out.println("Error during update");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            case 3: // Delete
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter airport ID to be deleted:");
                    ID= scan.nextInt();

                    conexion = DBcontrol.Connection();
                    statement = conexion.createStatement();

                    // Remove flight references in route
                    System.out.println("Deleting references to this airport in routes...");
                    rs = statement.executeUpdate("UPDATE route SET Airline = NULL WHERE departureID = " + ID + ";");
                    System.out.println("References removed in route departures: " + rs);

                    rs = statement.executeUpdate("UPDATE route SET Airline = NULL WHERE arrivalID = " + ID + ";");
                    System.out.println("References removed in route arrivals: " + rs);

                    // Remove references in airlines
                    rs = statement.executeUpdate("UPDATE airline SET Hub = NULL WHERE Hub = " + ID + ";");
                    System.out.println("References removed in airline hubs: " + rs);

                    //removes the airport itself
                    System.out.println("Removing flight...");
                    rs = statement.executeUpdate("DELETE FROM airport WHERE ID = " + ID + ";");
                    System.out.println("References removed in airport: " + rs);


                } catch (SQLException e) {
                    System.out.println("Error during deletion");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            default: System.out.println("Not an option");
        }
    }

    public static void fleets(int option) throws SQLException {
        Connection conexion = null;
        Statement statement = null;

        int ID;
        int airlineID;
        int planeID;
        int fleet;



        Scanner scan;

        int rs;

        switch (option) {
            case 1: // Insert
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter fleet:");
                    fleet = scan.nextInt();

                    System.out.println("Enter airline ID:");
                    airlineID = scan.nextInt();
                    System.out.println("Enter aircraft ID:");
                    planeID = scan.nextInt();


                    conexion = DBcontrol.Connection(); // connection + login credentials
                    statement = conexion.createStatement();

                    rs = statement.executeUpdate("INSERT INTO airlinefleets (PlaneID, fleet, AirlineID) VALUES (" + planeID + "," +fleet+ "," + airlineID+");");
                    System.out.println(rs);

                } catch (SQLException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            case 2: // Update
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter fleet ID:");
                    ID = scan.nextInt();

                    System.out.println("Enter new fleet:");
                    fleet = scan.nextInt();
                    System.out.println("Enter new airline ID:");
                    airlineID = scan.nextInt();
                    System.out.println("Enter new aircraft ID:");
                    planeID = scan.nextInt();

                    conexion = DBcontrol.Connection();
                    statement = conexion.createStatement();

                    rs=statement.executeUpdate("UPDATE airlinefleets SET PlaneID = '" + planeID+ "', fleet = '" + fleet + "', AirlineID = '"+airlineID+"WHERE ID = " + ID + ";");
                } catch (SQLException e) {
                    System.out.println("Error during update");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            case 3: // Delete
                try {
                    scan = new Scanner(System.in);
                    System.out.println("Enter airport ID to be deleted:");
                    ID= scan.nextInt();

                    conexion = DBcontrol.Connection();
                    statement = conexion.createStatement();

                    //removes the fleet
                    System.out.println("Removing fleet...");
                    rs = statement.executeUpdate("DELETE FROM airlinefleets WHERE ID = " + ID + ";");
                    System.out.println("References removed in airlinefleets: " + rs);


                } catch (SQLException e) {
                    System.out.println("Error during deletion");
                    e.printStackTrace();
                } finally {
                    DBcontrol.disconnect(conexion, statement);
                }
                break;

            default: System.out.println("Not an option");
        }
    }

    public static void nullValues(){
        Connection conexion = null;
        Statement statement = null;
        try {
            conexion = DBcontrol.Connection(); //connection+login credentials

            statement = conexion.createStatement();

            ResultSet rs = statement.executeQuery("""
                SELECT * FROM nullchecker WHERE FlightID IS NULL OR departureDate IS NULL 
                OR arrivalDate IS NULL 
                OR DepartureAirportID IS NULL 
                OR ArrivalAirportID IS NULL 
                OR DepartureAirport IS NULL 
                OR ArrivalAirport IS NULL 
                OR AirlineName IS NULL 
                OR AircraftName IS NULL 
                OR FleetCount IS NULL 
                OR AircraftManufacturer IS NULL 
                OR HubName IS NULL OR HubCountry IS NULL;
                """);
            // Print headers (chatgpt)
            System.out.println("FlightID\tDepartureDate\tArrivalDate\tDepartureAirportID\tArrivalAirportID\t"+"DepartureAirport\tArrivalAirport\tAirlineName\tAircraftName\tFleetCount\tAircraftManufacturer\tHubName\tHubCountry");

            //query results
            while (rs.next()) {
                int flightID = rs.getInt("FlightID");
                String departureDate = rs.getString("departureDate");
                String arrivalDate = rs.getString("arrivalDate");
                int departureAirportID = rs.getInt("DepartureAirportID");
                int arrivalAirportID = rs.getInt("ArrivalAirportID");
                String departureAirport = rs.getString("DepartureAirport");
                String arrivalAirport = rs.getString("ArrivalAirport");
                String airlineName = rs.getString("AirlineName");
                String aircraftName = rs.getString("AircraftName");
                int fleetCount = rs.getInt("FleetCount");
                String aircraftManufacturer = rs.getString("AircraftManufacturer");
                String hubName = rs.getString("HubName");
                String hubCountry = rs.getString("HubCountry");

                // Print rows (also chatGPT)
                System.out.println(flightID + "\t" + departureDate + "\t" + arrivalDate + "\t" + departureAirportID + "\t" + arrivalAirportID + "\t" + departureAirport + "\t" + arrivalAirport + "\t" + airlineName + "\t" + aircraftName + "\t" + fleetCount + "\t" + aircraftManufacturer + "\t" + hubName + "\t" + hubCountry);
            }




        } catch (SQLException ex) {
            System.out.println("Error");
            ex.printStackTrace();
        } finally {
            DBcontrol.disconnect(conexion, statement);
        }
    }



}
