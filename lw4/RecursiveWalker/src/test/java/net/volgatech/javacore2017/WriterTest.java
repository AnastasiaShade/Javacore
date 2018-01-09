package net.volgatech.javacore2017;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WriterTest {

    private final ArrayList<String> hashSums = new ArrayList<>(Arrays.asList("0000001d", "000000a7"));
    private final ArrayList<String> paths = new ArrayList<>(Arrays.asList("testData\\ho\\jh\\row\\koko.txt", "testData\\ho\\jh\\row\\row.txt"));
    private final String expectedResult = "0000001d testData\\ho\\jh\\row\\koko.txt\n000000a7 testData\\ho\\jh\\row\\row.txt\n";
    @Test
    public void printResult() throws IOException {
        Writer writer = new Writer("testOut.txt");
        writer.printResult(hashSums, paths);
        String result = getTestResult("testOut.txt");
        Assert.assertEquals(expectedResult, result);
    }

    private String getTestResult(String fileName) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        FileReader fileReader = new FileReader(fileName);
        Scanner reader = new Scanner(fileReader);
        while (reader.hasNext()) {
            String part = reader.nextLine();
            result.append(part + "\n");
        }
        return result.toString();
    }
}