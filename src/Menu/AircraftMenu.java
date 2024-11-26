package Menu;

import Drivers.DBquery;

import java.sql.SQLException;
import java.util.Scanner;

public class AircraftMenu {

    static Scanner scan;
    static int option;

    public static void menu(){

        scan= new Scanner(System.in);

        System.out.println("Aircraft:");
        System.out.println("-1 By manufacturer:");
        System.out.println("-2 Model:");
        System.out.println("-3 Overall data:");

        System.out.println("Selected option: ");
        option = scan.nextInt();
        switch (option) {
            case (1):
                try {
                    DBquery.allAircraft(1);

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
                    DBquery.allAircraft(2);

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
                    DBquery.allAircraft(3);

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }
}
