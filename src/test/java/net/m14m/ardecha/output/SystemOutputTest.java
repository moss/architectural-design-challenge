package net.m14m.ardecha.output;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class SystemOutputTest extends OutputContract {
    private PrintStream realSystemOut;
    private ByteArrayOutputStream fakeSystemOut;

    @Before public void replaceSystemOut() throws Exception {
        realSystemOut = System.out;
        fakeSystemOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeSystemOut));
    }

    @Override protected Output getOutput() {
        return new SystemOutput();
    }

    @Override protected void shouldHavePrinted(String expectedOutput) throws UnsupportedEncodingException {
        assertEquals(expectedOutput, fakeSystemOut.toString("utf-8"));
    }

    @After public void restoreSystemOut() {
        System.setOut(realSystemOut);
    }
}
