package net.m14m.ardecha.output;

import net.m14m.ardecha.characters.TranslatableCharacter;
import org.junit.*;

public abstract class OutputContract {
    @Test public void shouldPrintCharacters() throws Exception {
        Output output = getOutput();
        output.writeChar(new TranslatableCharacter('t'));
        output.writeChar(new TranslatableCharacter('e'));
        output.writeChar(new TranslatableCharacter('s'));
        output.writeChar(new TranslatableCharacter('t'));
        shouldHavePrinted("test");
    }

    protected abstract Output getOutput();

    protected abstract void shouldHavePrinted(String expectedOutput) throws Exception;
}
