import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.File;
import java.util.Scanner;


public class AskUser {
    Logger log = LoggerFactory.getLogger(AskUser.class);

    Scanner scan = new Scanner(System.in);

    public String pideString(){
        log.info("Escribe el nombre de usuario: ");
        return scan.nextLine();
    }

    public File pidePath(){
        log.info("Escribe la ruta del fichero ");
        File file = new File( scan.nextLine());
        return file;
    }

}
