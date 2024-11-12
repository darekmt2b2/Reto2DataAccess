package Menu;

import java.util.Scanner;

public class Menu {

    public static void menuDisplay() {
        int limit = 0;
        int option;

        Scanner scan = new Scanner(System.in);

        while (limit == 0) {

            System.out.println("European Flag Carrier Airspace \n what would you like to do today?");
            System.out.println("1.Check flight history:");
            System.out.println("2.Explore Airlines:");
            System.out.println("3.Explore Airports");
            System.out.println("4.Dev mode");

            option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.println("- Before:");
                    System.out.println("- After:");
                    System.out.println("- During:");
                    System.out.println("- Between:");

                    System.out.println("Selected option: ");
                    option = scan.nextInt();
                    switch (option) {
                        case (1):
                            //method
                            break;
                        case (2):
                            //method
                            break;
                        case (3):
                            //method
                            break;
                        case (4):
                            //method
                            break;
                    }

                    break;
                case (2):
                    break;
                case (3):
                    break;
                case (4):
                    break;


            }


        }
    }
}
