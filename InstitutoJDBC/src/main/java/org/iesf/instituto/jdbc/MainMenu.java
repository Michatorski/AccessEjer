package org.iesf.instituto.jdbc;

import org.iesf.instituto.jdbc.program.GroupProgram;
import org.iesf.instituto.jdbc.program.StudentProgram;
import org.iesf.instituto.jdbc.program.TitleProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MainMenu {
    private final static Logger log = LoggerFactory.getLogger(MainMenu.class);

    private Scanner scan;
    private TitleProgram titleProgram;
    private StudentProgram studentProgram;
    private GroupProgram groupProgram;

    public MainMenu(Scanner scan, TitleProgram titleProgram, StudentProgram studentProgram, GroupProgram groupProgram) {
        this.scan = scan;
        this.titleProgram = titleProgram;
        this.studentProgram = studentProgram;
        this.groupProgram = groupProgram;
    }

    public void mainMenu() {
        boolean salir = false;
        while (!salir){
            log.info("Bienvenido. Escoge la opicion que quiere realizar.");
            log.info("1. Listar Titulos.");
            log.info("2. Listar Alumnos.");
            log.info("3. Listar Grupos.");
            log.info("4. Insertar Titulos.");
            log.info("5. Insertar Alumnos.");
            log.info("6. Insertar Grupos.");
            log.info("7. Listar familias en Instituto");
            log.info("8. Listar Titulos segun familia");
            log.info("9. Cerrar aplicacion");

            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    titleProgram.list();
                    break;
                case 2:
                    studentProgram.list();
                    break;
                case 3:
                    groupProgram.list();
                    break;
                case 4:
                    titleProgram.insert();
                    break;
                case 5:
                    studentProgram.insert();
                    break;
                case 6:
                    groupProgram.insert();
                    break;
                case 7:
                    titleProgram.familySearch();
                    break;
                case 8:
                    log.info("¿Que familia quieres filtrar los titulos?");
                    titleProgram.listTitleByFamily(scan.nextLine());
                    break;
                case 9:
                    salir = true;
                    break;
            }
        }

    }
}
