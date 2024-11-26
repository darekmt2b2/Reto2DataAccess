package Menu;

import Drivers.Filter;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public static void menuDisplay(){
        int limit = 0;
        int option;

        Scanner scan = new Scanner(System.in);

        while (limit == 0) {
            System.out.println("==============================");
            System.out.println(" ");
            System.out.println("European Flag Carrier Airspace \n what would you like to do today?");
            System.out.println("1.Check flight history:");
            System.out.println("2.Explore Aircraft:");
            System.out.println("3.Explore Airports:");
            System.out.println("4.Explore Airlines:");
            System.out.println("5.Edit");
            System.out.println("6.SHOW ALL DATA");
            System.out.println("0.Exit");

            System.out.println("Selected option: ");

            option = scan.nextInt();

            switch (option) {
                case 1:
                    FlightMenu.menu();
                    break;
                case (2):
                    AircraftMenu.menu();
                    break;
                case (3):
                    AirportMenu.menu();
                    break;
                case (4):
                    AirlineMenu.airlineMenu();
                    break;
                case (5):
                    Filter.access(Filter.filter());
                    break;
                case (6):
                    ShowAll.showALL();
                    try{
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case (0):
                    System.out.println("See you soon!");
                    limit = 1;

                    break;
                default: System.out.println("Not an option");


            }


        }
    }
}
