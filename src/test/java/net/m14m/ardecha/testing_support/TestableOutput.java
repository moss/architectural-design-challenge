package net.m14m.ardecha.testing_support;

import net.m14m.ardecha.Output;

import java.io.StringWriter;

import static org.junit.Assert.*;

public class TestableOutput implements Output {
    private StringWriter output = new StringWriter();

    public void write(int character) {
        output.write(character);
    }

    public void shouldEqual(String expectedOutput) {
        assertEquals("output", expectedOutput, output.toString());
    }
}
