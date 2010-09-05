package net.m14m.ardecha.application;

import net.m14m.ardecha.characters.TranslatableCharacter;
import net.m14m.ardecha.input.*;
import net.m14m.ardecha.output.*;
import org.junit.*;

import java.io.IOException;

public class TranslationIoCoordinatorTest {
    private static final String FILE_CONTENTS = "abc";
    private static final String INPUT_FILENAME = "sample.txt";
    private static final String OUTPUT_FILENAME = "sample-translated.txt";
    private FakeInputRepository inputRepository = new FakeInputRepository();
    private FakeOutputFileRepository outputRepository = new FakeOutputFileRepository();
    private FakeOutput standardOutput = new FakeOutput();
    private TranslationIoCoordinator ioCoordinator;

    @Before public void setUpIoCoordinator() {
        ioCoordinator = new TranslationIoCoordinator(inputRepository, outputRepository,
                standardOutput, new IdentityTranslator());
    }

    @Before public void setUpFile() {
        inputRepository.createFile(INPUT_FILENAME, FILE_CONTENTS);
    }

    @Test public void shouldPrintRot13edInputToOutput() throws IOException {
        ioCoordinator.translate(INPUT_FILENAME, OUTPUT_FILENAME);
        standardOutput.shouldHavePrinted(FILE_CONTENTS);
        outputRepository.shouldContainFile(OUTPUT_FILENAME, FILE_CONTENTS);
    }

    private class IdentityTranslator implements Translator {
        public void translate(Input input, Output output) {
            for (TranslatableCharacter character : input) {
                output.writeChar(character);
            }
        }
    }
}
