import database.DBquery;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        try {
            DBquery.query("SELECT * FROM aircraft");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
