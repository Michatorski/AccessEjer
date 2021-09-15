package org.iesf.instituto.jdbc.scannerRead;

import org.iesf.instituto.jdbc.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class GroupScannerReader {
    private final static Logger log = LoggerFactory.getLogger(GroupScannerReader.class);

    private Scanner scanner;

    public GroupScannerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Group readScanGroup(){
        log.info("Introduce 'course' del titleGroup");
        String course = scanner.nextLine();
        log.info("Introduce 'letter' del titleGroup");
        String letter = scanner.nextLine();
        log.info("Introduce 'title' del titleGroup");
        String title = scanner.nextLine();
        log.info("Introduce 'year' del titleGroup");
        int year = scanner.nextInt();
        scanner.nextLine();

        return  new Group(null, course,letter,title,year);
    }

}
