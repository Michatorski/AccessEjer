package iesfm.org;

import iesfm.org.program.DepartmentProgram;
import iesfm.org.program.EmployeeProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MainMenu {
    private final static Logger log = LoggerFactory.getLogger(MainMenu.class);

    private Scanner scan;

    private DepartmentProgram departmentProgram;
    private EmployeeProgram employeeProgram;

    public MainMenu(Scanner scan, DepartmentProgram departmentProgram, EmployeeProgram employeeProgram) {
        this.scan = scan;
        this.departmentProgram = departmentProgram;
        this.employeeProgram = employeeProgram;
    }


    public void run() {
        boolean salir = false;
        while (!salir) {
            log.info("Bienvenido. Escoge la opicion que quiere realizar.");
            log.info("1. Listar Departamentos.");
            log.info("2. Listar Empleados.");
            log.info("3. Insertar Departamentos.");
            log.info("4. Cerrar aplicacion.");

            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    departmentProgram.list();
                    break;
                case 2:
                    log.info("¿Que departamento estas buscando?");
                    employeeProgram.listByDeparment(scan.nextLine());
                    break;
                case 3:
                    departmentProgram.insert();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    log.info("Error, debes poner un número o salir.");
            }
        }
    }
}
