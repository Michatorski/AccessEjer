package iesfm.org.reader;

import iesfm.org.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class DepartamentoReader {
    private final static Logger log = LoggerFactory.getLogger(DepartamentoReader.class);

    private Scanner scanner;

    public DepartamentoReader(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public Department readScanDepartment(){
        log.info("Introduce el 'name' del Deparment");
        String name = scanner.nextLine();

        log.info("Introduce el 'description' del Deparment");
        String description = scanner.nextLine();

        return new Department(name, description);
    }
}
