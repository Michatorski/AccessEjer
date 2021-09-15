package org.iesfm.serialización.aereolinea;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;


public class AereolineaMain {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        File iberiaFile = new File(AereolineaMain.class.getResource("/iberia.jason").toURI());

        Aereolinea aereolinea = mapper.readValue(iberiaFile,Aereolinea.class);

        System.out.println("");
    }
}
