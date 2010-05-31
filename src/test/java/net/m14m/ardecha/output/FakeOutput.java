package net.m14m.ardecha.output;

import java.io.StringWriter;

import static org.junit.Assert.*;

public class FakeOutput implements Output {
    private final StringWriter writer = new StringWriter();

    public void writeChar(int character) {
        writer.write(character);
    }

    public void shouldHavePrinted(String expectedOutput) {
        assertEquals("Output", expectedOutput, writer.toString());
    }
}
