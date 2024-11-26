package Menu;

import java.util.Scanner;

public class CrudMenu {
    
    static Scanner scan= new Scanner(System.in);
    public static int crudMenu(){
        
        int option;
        System.out.println("1.insert new instance");
        System.out.println("2.Update existing instance");
        System.out.println("3.Delete existing instance");

        System.out.println("Select your option:");
        
        option= scan.nextInt();
        
        return option;
    }
}
