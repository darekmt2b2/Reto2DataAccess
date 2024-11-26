package Menu;

import Drivers.DBquery;

import java.sql.SQLException;
import java.util.Scanner;

public class AirlineMenu {

    static Scanner scan;
    static int option;

    public static void airlineMenu(){

        scan= new Scanner(System.in);

        System.out.println("Airlines:");
        System.out.println("-1 By country:");
        System.out.println("-2 By hub:");
        System.out.println("-3 By name:");
        System.out.println("-4 Overall data:");

        System.out.println("Selected option: ");
        option = scan.nextInt();

        switch (option) {
            case (1):
                try {
                    DBquery.allAirlines(1);

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
                    DBquery.allAirlines(2);

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                //method
                break;
            case (3):
                try {
                    DBquery.allAirlines(3);

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                //method
                break;
            case (4):
                try {
                    DBquery.allAirlines(4);

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                //method
                break;
        }
    }
}
