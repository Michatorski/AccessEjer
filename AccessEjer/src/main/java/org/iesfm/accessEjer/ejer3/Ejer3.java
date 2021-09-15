package org.iesfm.accessEjer.ejer3;

import java.io.File;

public class Ejer3 {

    public static void showFiles(File folder) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                showFiles(file);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        File current = new File(".");

        showFiles(current);
    }
}
