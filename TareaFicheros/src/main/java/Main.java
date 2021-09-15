import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Find find = new Find();
        AskUser ask = new AskUser();

        find.readFile(ask.pidePath(), ask.pideString());

    }
}
