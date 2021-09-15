package iesfm.org.writeNumbersInText;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        int num = new AskUserInt().askUserNum();
        MakeFile makeFile = new MakeFile();
        WriteNumberInFile writeNumberInFile = new WriteNumberInFile();

        writeNumberInFile.writeNum(makeFile.makeFile(num), num);

    }
}
