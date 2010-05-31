package net.m14m.ardecha.output;

import org.junit.*;

public abstract class OutputContract {
    @Test public void shouldPrintCharacters() throws Exception {
        Output output = getOutput();
        output.writeChar('t');
        output.writeChar('e');
        output.writeChar('s');
        output.writeChar('t');
        shouldHavePrinted("test");
    }

    protected abstract Output getOutput();

    protected abstract void shouldHavePrinted(String expectedOutput) throws Exception;
}
