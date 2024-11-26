package Drivers;

import Drivers.FileManager;
import Edition.EditionMenu;
import Menu.Menu;

import java.io.FileWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;

//do it with ip or mac, get it done by 20/11/2024
public class Filter {

    public static boolean filter() {
        int MAX_ATTEMPTS = 3;
        int attempts = 0;
        Scanner scan = new Scanner(System.in);

        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Attempt " + (attempts + 1));
            System.out.print("Introduce your password: ");
            String password = scan.next();

            if (password.equals("Australia_2032")) {
                System.out.println("Access granted.");
                return true;
            } else {
                System.out.println("Incorrect password. Try again.");
                attempts++;
            }
        }

        System.out.println("Access denied. Too many failed attempts.");
        scan.close();
        return false;
    }

    public static void access(Boolean access){
        if (access){
           EditionMenu.menu();
        }else {
            try {
                // Get the local IP address
                InetAddress inetAddress = InetAddress.getLocalHost();
                String ipAddress = inetAddress.getHostAddress();

                try (FileWriter fileWriter = new FileWriter("data/blacklist.txt")) {
                    fileWriter.write("IP Address: " + ipAddress);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }

    public static void Blacklist_checker(){

        boolean verifier=true;
        ArrayList<String> blacklist = FileManager.blacklistRead("data/blacklist.txt");

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String ipAddress = inetAddress.getHostAddress();
            for (int i=0;i<blacklist.size();i++){
                if (ipAddress.equals(blacklist.get(i))){
                    verifier=false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if (verifier){
            System.out.println("Hii!");
            Menu.menuDisplay();
        }else {
            System.out.println("Access denied");
            System.exit(0);
        }
    }
}
