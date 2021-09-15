import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Find {
    Logger log = LoggerFactory.getLogger(AskUser.class);

    public String readFile (File file, String name){
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(name)){
                    log.info("El usuario ya esta registrado");
                } else {
                    try (FileWriter writer = new FileWriter(file, true)) {
                        writer.write(name);
                        log.info("El usuario a sido registrado correctamente");
                    } catch (IOException e) {
                        log.error("Error escribiendo en el archivo " + file.getName(), e);
                    }
                }
            }
        } catch (IOException e) {
            log.error("Error leyendo el archivo " + file.getName(), e);
        }

        return builder.toString();
    }
}
