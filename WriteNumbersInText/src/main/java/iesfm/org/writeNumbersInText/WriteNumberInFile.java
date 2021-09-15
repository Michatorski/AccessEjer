package iesfm.org.writeNumbersInText;


import java.io.*;

public class WriteNumberInFile {

    public void writeNum(File file, int num) {
        try (FileWriter writer = new FileWriter(file)) {

            for (int i = 0; i < num; i++) {
                writer.write(i + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
