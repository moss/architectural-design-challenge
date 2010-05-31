package net.m14m.ardecha.input;

import org.junit.*;

import java.io.StringReader;

import static org.junit.Assert.*;

public class InputTest {
    private StringReader reader = new StringReader("foo");
    private Input input;

    @Before public void setUp() throws Exception {
        input = new Input(reader);
    }

    @Test public void shouldIterateOverCharacters() {
        assertEquals('f', input.readChar());
        assertEquals('o', input.readChar());
        assertEquals('o', input.readChar());
    }
}
