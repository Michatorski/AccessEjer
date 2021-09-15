package org.iesfm.findAndList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println( "introduce el path al archivo");
        String inputPath  = scan.nextLine();
        System.out.println("Introduce el path al archivo");
        String outputFile = scan.nextLine();


    }


}
