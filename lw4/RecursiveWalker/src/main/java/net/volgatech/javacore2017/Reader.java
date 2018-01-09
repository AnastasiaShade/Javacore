package net.volgatech.javacore2017;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    private String fileName;

    public ArrayList<String> readPaths() throws FileNotFoundException {
        ArrayList<String> paths = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        Scanner reader = new Scanner(fileReader);
        while (reader.hasNext()) {
            String path = reader.nextLine();
            paths.add(path);
        }
        return paths;
    }
}
