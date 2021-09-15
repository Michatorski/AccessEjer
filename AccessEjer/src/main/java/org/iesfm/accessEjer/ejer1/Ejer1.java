package org.iesfm.accessEjer.ejer1;

import java.io.File;

public class Ejer1 {
    public static void main(String[] args) {
        File userPath = new File("/home/micho");

        userPath.list();

        for (String file: userPath.list()) {
            System.out.println(file);
        }
    }
}
