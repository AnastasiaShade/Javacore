package net.volgatech.javacore2017;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
    public Writer(String fileName) {
        this.fileName = fileName;
    }

    private String fileName;

    public void printResult(ArrayList<String> hashSums, ArrayList<String> filePaths) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for (int i = 0; i < hashSums.size(); ++i) {
            writer.write(hashSums.get(i) + " " + filePaths.get(i));
            writer.write(System.getProperty("line.separator"));
        }
        writer.flush();
        writer.close();
    }
}
