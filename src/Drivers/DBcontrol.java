package Drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBcontrol {

    public static Connection Connection () throws SQLException {

        Connection conexion = null;

        try {
            //establishes connection to our database
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/euroairspace", "Darek", "Australia_2032");// user credentials
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }

        return conexion;
    }

    public static void disconnect(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
