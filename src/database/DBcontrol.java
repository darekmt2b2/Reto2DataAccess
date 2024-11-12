package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcontrol {

    public static Connection Connection () throws SQLException {

        Connection conexion = null;

        try {
            //conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/euroairspace", "Darek", "Australia_2032");// proporcionamos la dirección, el administrador y la clave
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }

        return conexion;
    }
}
