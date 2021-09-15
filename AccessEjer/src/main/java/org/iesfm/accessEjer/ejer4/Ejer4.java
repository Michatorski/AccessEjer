package org.iesfm.accessEjer.ejer4;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;


public class Ejer4 {

    //"home/micho" ubuntu
    //"c://Users/OmegaKnight" windows

    private static Logger log = LoggerFactory.getLogger(Ejer4.class);

    private static void makeDir (String directory)throws IOException{
        File pathDir = new File("/tmp/" + directory);

        pathDir.mkdir();

    }

    private static void makeFile(String dir, String filename) throws  IOException{
        File file = new File ("/tmp/" + dir + "/" + filename);

        file.createNewFile();
    }

    public static void main(String[] args) {

        try {
            log.info("Creando directorio d1...");
            makeDir("d1");
            log.info("Creando fichero f11.txt...");
            makeFile("d1", "f11.txt");

            log.info("Creando directorio d2...");
            makeDir("d2");
            log.info("Creando fichero f21.txt...");
            makeFile("d2", "f21.txt");
        }catch (IOException e){
           log.error("Ha habido un error als crear los archivos", e);
        }

    }
}
