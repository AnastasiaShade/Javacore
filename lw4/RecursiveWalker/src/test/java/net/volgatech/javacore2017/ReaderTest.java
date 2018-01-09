package net.volgatech.javacore2017;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReaderTest {

    private final ArrayList<String> expected = new ArrayList<>(Arrays.asList("testData/", "testData/ho/jh/row/koko.txt", "testData/ho/jh"));
    private ExpectedException thrown = ExpectedException.none();

    @Test
    public void readFromNotExistentFile() {
        thrown.expect(FileNotFoundException.class);
        thrown.expectMessage("File not found");
        Reader reader = new Reader("input.txt");
        try {
            ArrayList<String> result = reader.readPaths();
            Assert.fail();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readFromExistentFile() throws IOException {
        Reader reader = new Reader("testFile.txt");
        ArrayList<String> result = reader.readPaths();
        Assert.assertEquals(expected, result);
    }
}