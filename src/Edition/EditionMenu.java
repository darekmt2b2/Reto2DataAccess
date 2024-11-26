package Edition;

import Menu.CrudMenu;
import java.util.Scanner;

public class EditionMenu {
    static Scanner scan;
    static int option;

    public static  void menu(){



        System.out.println("Tables available:");
        System.out.println("1-Flights 2-Airlines 3-Aircraft 4-Fleet 5-Airport.");
        System.out.println("9-Check null values.");

        scan= new Scanner(System.in);


        System.out.println("Selected option: ");

        option = scan.nextInt();
        switch (option) {
            case (1):
                try {
                    DBcrud.flights(CrudMenu.crudMenu());

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                break;
            case (2):
                try {
                    DBcrud.airline(CrudMenu.crudMenu());

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case (3):
                try {
                    DBcrud.aircraft(CrudMenu.crudMenu());

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case (4):
                try {
                    DBcrud.fleets(CrudMenu.crudMenu());

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case (5):
                try {
                    DBcrud.airports(CrudMenu.crudMenu());

                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case (9):
                try {
                    DBcrud.nullValues();
                    try {
                        Thread.sleep(3000); // 3000 milliseconds = 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                //method
                break;
            default: System.out.println("not an option");

        }





    }
}
