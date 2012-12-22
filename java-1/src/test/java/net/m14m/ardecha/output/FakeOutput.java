package net.m14m.ardecha.output;

import net.m14m.ardecha.characters.TranslatableCharacter;

import java.io.StringWriter;

import static org.junit.Assert.*;

public class FakeOutput implements Output {
    private final StringWriter writer = new StringWriter();

    public void writeChar(TranslatableCharacter translatableCharacter) {
        writer.write(translatableCharacter.toInteger());
    }

    public void shouldHavePrinted(String expectedOutput) {
        assertEquals("Output", expectedOutput, writer.toString());
    }
}
