package org.iesfm.accessEjer.ejer2;

import java.io.File;

public class Ejer2 {

    public static void main(String[] args) {
        File currentDirectory= new File(".");

        System.out.println(currentDirectory.getAbsolutePath());
    }
}
