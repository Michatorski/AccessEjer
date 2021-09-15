package org.iesf.instituto.jdbc.scannerRead;

import org.iesf.instituto.jdbc.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class StudentScannerReader {
    private final static Logger log = LoggerFactory.getLogger(StudentScannerReader.class);

    private Scanner scanner;

    public StudentScannerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Student readScanStudent(){
        log.info("Introduce 'nif' del Student");
        String nif = scanner.nextLine();
        log.info("Introduce 'name' del Student");
        String name = scanner.nextLine();
        log.info("Introduce 'surname' del Student");
        String surname = scanner.nextLine();
        log.info("Introduce 'zipCode' del Student");
        int zipCode = scanner.nextInt();
        scanner.nextLine();
        log.info("Introduce 'address' del Student");
        String address = scanner.nextLine();
        log.info("Introduce 'email' del Student");
        String email = scanner.nextLine();

        return  new Student(nif,name, surname, zipCode, address, email);
    }
}
