package net.volgatech.javacore2017;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class RecursiveWalkTest {

    private ExpectedException thrown = ExpectedException.none();

    @Test()
    public void testStartProgramWithNotExistentFile() {
        thrown.expect(IOException.class);
        thrown.expectMessage("File not found");
        RecursiveWalk.main(new String[]{"test.txt", "output.txt"});
    }

    @Test
    public void testStartProgramWithoutArgs() {
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Invalid arguments count");
        RecursiveWalk.main(new String[]{});
    }
}