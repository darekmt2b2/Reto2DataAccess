package Menu;

import Drivers.DBquery;

import java.sql.SQLException;
import java.util.Scanner;

public class AirportMenu {

    static Scanner scan;
    static int option;
    public static void menu() {

        scan = new Scanner(System.in);

        System.out.println("Airport:");
        System.out.println("-1 By IATA:");
        System.out.println("-2 By City:");
        System.out.println("-3 By Country:");
        System.out.println("-4 By Continent:");
        System.out.println("-5 Overall data:");

        System.out.println("Selected option: ");
        option = scan.nextInt();
        switch (option) {
            case (1):
                try {
                    DBquery.allAirports(1);

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (2):
                try {
                    DBquery.allAirports(2);

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (3):
                try {
                    DBquery.allAirports(3);

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
                    DBquery.allAirports(4);

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
                    DBquery.allAirports(5);

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
