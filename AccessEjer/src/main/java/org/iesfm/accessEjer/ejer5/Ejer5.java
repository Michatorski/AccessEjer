package org.iesfm.accessEjer.ejer5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Ejer5 {

    public static Logger log = LoggerFactory.getLogger(Ejer5.class);

    private static void move(String origin, String destination) {

        log.info("Moviendo el archivo " + origin + " a " + destination);
        File file = new File(origin);

        file.renameTo(new File(destination));
    }

    private static void delete(String path) {
        log.info("Eliminando directorio " + path);
        File file = new File(path);
        file.delete();
    }

    //cambie el nombre de f11.txt a f12.txt, meuve el
    //fichero f12.txt al directorio d1 y eliminalo despues el dierctorio d2

    public static void main(String[] args) {
        move("/tmp/d1/f11.txt", "/tmp/d1/f12.txt");
        move("/tmp/d2/f11.txt", "/tmp/d1/f21.txt");
        delete("/tmp/d2");
    }
}
