package net.m14m.ardecha.output;

import java.io.*;

import static org.junit.Assert.*;

public class PrintStreamOutputTest extends OutputContract {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Override protected Output getOutput() {
        return new PrintStreamOutput(new PrintStream(outputStream));
    }

    @Override protected void shouldHavePrinted(String expectedOutput) throws UnsupportedEncodingException {
        assertEquals(expectedOutput, outputStream.toString("utf-8"));
    }
}
