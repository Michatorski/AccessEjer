package org.iesfm.accessEjer.ejer6;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;

public class Ejer6 {
    public static  Logger log = LoggerFactory.getLogger(Ejer6.class);

    public static void showInfoFile (File fileToCheck) {

        log.info("Nombre: " + fileToCheck.getName());
        log.info("Ruta Absoluta: " + fileToCheck.getAbsolutePath());
        log.info("Tamaño: " + fileToCheck.length());
        log.info("Es un archivo? " + fileToCheck.isFile());
        log.info("Es un direcotry? " + fileToCheck.isDirectory());
        log.info("Ultima Modificacion: " + fileToCheck.lastModified());
        log.info("Permiso para escribir: " + fileToCheck.canWrite());
        log.info("Permiso para leer: " + fileToCheck.canRead());
        log.info("Permiso para ejecutar: " + fileToCheck.canExecute());

    }

    public static void main(String[] args) {



        if ( args.length == 0){
           log.error("Debe introducir argumento.");
        } else {
            File file = new File (args[0]);

            showInfoFile(file);
        }



    }
}
