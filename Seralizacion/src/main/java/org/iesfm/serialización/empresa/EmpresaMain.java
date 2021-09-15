package org.iesfm.serialización.empresa;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

public class EmpresaMain {
    private final static Logger log = LoggerFactory.getLogger(Empresa.class);

    public static void main(String[] args) {


        String nameDepart = "Recursos Humanos";

        try {
            ObjectMapper mapper = new ObjectMapper();
            Empresa empresa = mapper.readValue(
                    new File(Empresa.class.getResource("/pepsi.json").toURI()
                    ), Empresa.class);
            log.info(empresa.toString());

            mapper.writeValue(
                    new FileOutputStream(new File( nameDepart +"-empleados.json")),
                    empresa.getListaEmpleados(nameDepart)
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
