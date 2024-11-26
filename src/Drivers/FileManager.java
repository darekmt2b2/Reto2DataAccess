package Drivers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private static FileReader fichero = null;
    private static BufferedReader lector = null;
    private static String cadena;

    //un buffered es una pajita,sorbe en una determinada zona,necesita liquido para ser usada(el filereader)

    public static ArrayList<String> readFile(){
        ArrayList<String> Strings = new ArrayList<String>();


        try {
            fichero = new FileReader("data/blacklist.txt");
            lector = new BufferedReader(fichero);

            while ((cadena = lector.readLine()) !=null) {
                Strings.add(cadena);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Strings;
    }
    public static ArrayList<String> blacklistRead(String path) {
        ArrayList<String> ipList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String ip = line.split(":")[1].trim();
                ipList.add(ip);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ipList;
    }

}


