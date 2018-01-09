package net.volgatech.javacore2017;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class HashSumCreatorTest {

    private final ArrayList<String> expectedHashSum = new ArrayList<>(Arrays.asList("0000001d"));
    private final ArrayList<String> expectedPath = new ArrayList<>(Arrays.asList("testData/ho/jh/row/koko.txt"));

    private final ArrayList<String> expectedHashSums = new ArrayList<>(Arrays.asList("0000001d", "000000a7"));
    private final ArrayList<String> expectedPaths = new ArrayList<>(Arrays.asList("testData\\ho\\jh\\row\\koko.txt", "testData\\ho\\jh\\row\\row.txt"));

    private ExpectedException thrown = ExpectedException.none();
    private HashSumCreator creator = new HashSumCreator();

    @Before
    public void prepareInfo() throws IOException {
        creator.walk("testData/ho/jh/row/koko.txt");
    }

    @Test
    public void getFilePaths() {
        Assert.assertEquals(expectedPath, creator.getFilePaths());
    }

    @Test
    public void getHashSums() {
        Assert.assertEquals(expectedHashSum, creator.getHashSums());
    }

    @Test
    public void walk() {
        HashSumCreator creator = new HashSumCreator();
        try {
            creator.walk("testData/ho/jh/row");
            Assert.assertEquals(expectedPaths, creator.getFilePaths());
            Assert.assertEquals(expectedHashSums, creator.getHashSums());
        } catch (IOException e) {
            Assert.fail();
        }
    }
}