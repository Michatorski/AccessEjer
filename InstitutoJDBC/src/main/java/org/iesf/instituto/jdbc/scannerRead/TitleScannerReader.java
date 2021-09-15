package org.iesf.instituto.jdbc.scannerRead;

import org.iesf.instituto.jdbc.Title;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class TitleScannerReader {

    private final static Logger log = LoggerFactory.getLogger(TitleScannerReader.class);

    private Scanner scanner;

    public TitleScannerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Title readScanInstituto(){
        log.info("Introduce 'name' del Title");
        String name = scanner.nextLine();
        log.info("Introduce 'level' del Title");
        String level = scanner.nextLine();
        log.info("Introduce 'family' del Title");
        String family = scanner.nextLine();
        log.info("Introduce 'description' del Title");
        String description = scanner.nextLine();

        return new Title(null, name, level, family, description);
    }
}
