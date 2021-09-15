import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class TiendaMain {
    private final static Logger log = LoggerFactory.getLogger(TiendaMain.class);

    public static void main(String[] args) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Tienda tienda = mapper.readValue(
                    new File(Tienda.class.getResource("/tienda.json").toURI()),
                    Tienda.class);
            log.info(String.valueOf(tienda.getOrders().size()));

        } catch (
                URISyntaxException e) {
            log.error("", e);
        } catch (
                JsonMappingException e) {
            log.error("El json no esta bien formado", e);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
