package org.iesfm.serialización.edificio;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iesfm.serialización.empresa.Empresa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

public class EdificioMain {
    private final static Logger log = LoggerFactory.getLogger(Edificio.class);

    public static void main(String[] args) {

       int planta = 1;

        try {
            ObjectMapper mapper = new ObjectMapper();
            Edificio edificio = mapper.readValue(
                    new File(Edificio.class.getResource("/edificio.json").toURI()
                    ), Edificio.class);
            log.info(edificio.toString());

            mapper.writeValue(
                    new FileOutputStream(new File(  "apartamentos-" + planta +".json")),
                    edificio.getApartamentoList(planta)
            );
        } catch (URISyntaxException e) {
            log.error("", e);
        } catch (JsonMappingException e) {
            log.error("El json no esta bien formado", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
