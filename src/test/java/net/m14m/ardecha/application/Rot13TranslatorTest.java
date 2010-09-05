package net.m14m.ardecha.application;

import net.m14m.ardecha.input.Input;
import net.m14m.ardecha.output.FakeOutput;
import org.junit.*;

import java.io.IOException;

public class Rot13TranslatorTest {
    private FakeOutput output = new FakeOutput();
    private Rot13Translator translator = new Rot13Translator();

    @Test public void shouldPrintRot13edInputToOutput() throws IOException {
        translator.translate(new Input("abc"), output);
        output.shouldHavePrinted("nop");
    }
}
