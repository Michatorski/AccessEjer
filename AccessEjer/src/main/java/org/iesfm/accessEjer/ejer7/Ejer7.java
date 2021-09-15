package org.iesfm.accessEjer.ejer7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Ejer7 {

    public static Logger log = LoggerFactory.getLogger(Ejer7.class);

    public static void showInfoFile (File fileToCheck) {

        log.info("Permiso para leer: " + fileToCheck.canRead());

        log.info("Permiso para ejecutar: " + fileToCheck.canExecute());

    }

    public static void modPermissions (File file){
        log.info("Cambiando perimiso de lectura. " + file.setReadable(false));
        log.info("Cambiando perimiso de ejecucion. " + file.setExecutable(false));
    }

    public static void main(String[] args) {

        File file = new File(args[0]);

        if (file.exists()){
            showInfoFile(file);
            modPermissions(file);
            showInfoFile(file);
        }

    }
}
