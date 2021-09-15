package iesfm.org.writeNumbersInText;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class AskUserInt {

    public static Logger log = LoggerFactory.getLogger(AskUserInt.class);

    public static Scanner scan = new Scanner(System.in);

    public int askUserNum(){
        log.info("Introduce un numero entero: ");
       return scan.nextInt();
    }
}
