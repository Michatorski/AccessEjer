package org.iesfm.accessEjer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileProgram {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("introduce ruta donde guardar el fichero");
        String path = scan.nextLine();

        File userFolder = new File(path);

        if (userFolder.exists()) {
            System.out.println("Introduce el nombre de usuario");
            String user = scan.nextLine();

            File file = new File(path + user + ".txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("no se pudo crear archivo" + e.getMessage());
            }

        } else {
            System.out.println("No existe la ruta " + path);
        }
    }

}

