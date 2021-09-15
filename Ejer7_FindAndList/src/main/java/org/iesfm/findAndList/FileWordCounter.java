package org.iesfm.findAndList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileWordCounter {
    private File file;

    public FileWordCounter(File file) {
        this.file = file;
    }

    public Map<String, Integer> countWords() throws IOException {
        Map<String, Integer> wordcount = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("");
                for (String word : words) {
                    if (wordcount.containsKey(word)){
                        int count = wordcount.get(word) + 1;
                        wordcount.put(word, wordcount.get(word) + 1);
                    } else {
                        wordcount.put(word, 1);
                    }
                }
            }
        }

        return wordcount;
    }
}
