package org.iesfm.accessEjer;

import org.iesfm.accessEjer.ejer7.Ejer7;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Ejer9 {
    public static Logger log = LoggerFactory.getLogger(Ejer9.class);

    public static void checkArgInfo(File file){
        if (file.exists()){

            if (file.isDirectory()){
                log.info("Nombre: " + file.getName());
            } else if(file.isFile()){
                log.info("Nombre: " + file.getName());
                log.info("Tamaño: " + file.length());
            }

        }else {
            log.error("No existe path.");
        }
    }

    public static void main(String[] args) {
        File file = new File( args[0]);

        if (args.length == 0){
            log.error("Necesario argumento");
        } else {
            checkArgInfo(file);
        }


    }

}
