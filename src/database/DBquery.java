package database;

import java.sql.*;

public class DBquery {


    public static void query(String query) throws SQLException {
        Connection conexion = null;
        Statement statement = null;
        int id;
        String name;
        String series;
        String manufacturer;


        try {
            conexion = DBcontrol.Connection(); //connection+login credentials

            statement = conexion.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                id = rs.getInt("id"); // Gets item's id
                name = rs.getString("Name"); // doctor assigned
                series = rs.getString("Series"); // med prescribed
                manufacturer = rs.getString("Manufacturer"); // issued prescription date

                // Print the data
                System.out.println("ID: " + id + "," + name + ", series: " + series+", manufacturer: "+manufacturer);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error");
        } finally {
            statement.close();
            conexion.close();
        }

    }

}








