package iesfm.org.writeNumbersInText;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

public class MakeFile {

    public File makeFile(int num) {
        File file = new File("/tmp/" + num + ".txt");
        return file;
    }
}
