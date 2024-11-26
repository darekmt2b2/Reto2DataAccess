package Menu;

import Drivers.DBquery;

import java.sql.SQLException;
import java.util.Scanner;

public class FlightMenu {

    static Scanner scan;
    static int option;

    public static  void menu(){

        scan= new Scanner(System.in);

        System.out.println("Flights:");
        System.out.println("-1 Before:");
        System.out.println("-2 After:");
        System.out.println("-3 During:");
        System.out.println("-4 Between:");
        System.out.println("-5 Overall Data:");

        System.out.println("Selected option: ");

        option = scan.nextInt();
        switch (option) {
            case (1):

                break;
            case (2):
                //method
                break;
            case (3):
                try {
                    DBquery.allFlights(3);

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (4):
                try {
                    DBquery.allFlights(4);

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (5):
                try {
                    DBquery.allFlights(5);

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default: System.out.println("not an option");

        }





    }
}
