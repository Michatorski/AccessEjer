package org.iesfm.serialización.aereolinea;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.iesfm.serialización.edificio.Edificio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class XStreamMain {
    private final static Logger log = LoggerFactory.getLogger(Edificio.class);

    public static void main(String[] args) {
        XStream xStream = new XStream(new StaxDriver());
        xStream.allowTypesByWildcard(new String[]{
                "org.iesfm.xStreamMain"
        });
        xStream.processAnnotations(Aereolinea.class);
        xStream.processAnnotations(Flight.class);
        xStream.processAnnotations(Passenger.class);
        try {
            Aereolinea aereolinea = (Aereolinea) xStream.fromXML(new File("/iberia.xml"), Aereolinea.class);
            log.info(aereolinea.toString());
        } catch (){

        }
    }
}
