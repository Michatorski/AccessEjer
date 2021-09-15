package org.iesfm.accessEjer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PrintLog {

    private static Logger log = LoggerFactory.getLogger(PrintLog.class);

    public static void main(String[] args) {
        File logs = new File(args[0]);
        // antiguo
//        FileInputStream fis = null;
//        try {
//             fis = new FileInputStream((logs));
//            byte[] fileInBites = fis.readAllBytes();
//            String content = new String(fileInBites, StandardCharsets.UTF_8);
//            fis.close();
//        } catch (FileNotFoundException e) {
//           log.error("No se a encontrado archivo" + args[0]);
//        } catch (IOException e){
//            log.error("Error al leer archivo" , e);
//        } finally {
//            try {
//                fis.close();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }

        //mejora
        try (FileInputStream fis = new FileInputStream(logs)) {
            byte[] fileInBites = fis.readAllBytes();
            String content = new String(fileInBites, StandardCharsets.UTF_8);
            fis.close();
        } catch (FileNotFoundException e) {
           log.error("No se a encontrado archivo" + args[0]);
        } catch (IOException e){
            log.error("Error al leer archivo" , e);
        }
    }
}
