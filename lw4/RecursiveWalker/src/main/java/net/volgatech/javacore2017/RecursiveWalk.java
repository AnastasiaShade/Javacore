package net.volgatech.javacore2017;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RecursiveWalk {
    private static final int ARGUMENTS_COUNT_VALUE = 2;

    public static void main(String args[])
    {
        try {
            if (args.length < ARGUMENTS_COUNT_VALUE) {
                throw new IndexOutOfBoundsException("Invalid arguments count");
            }

            Reader reader = new Reader(args[0]);
            ArrayList<String> paths = reader.readPaths();

            HashSumCreator walker = new HashSumCreator();
            for (String path : paths) {
                walker.walk(path);
            }
            Writer writer = new Writer(args[1]);
            writer.printResult(walker.getHashSums(), walker.getFilePaths());
        }
        catch (IOException | IndexOutOfBoundsException err) {
            System.out.println(err.getMessage());
        }
    }
}
