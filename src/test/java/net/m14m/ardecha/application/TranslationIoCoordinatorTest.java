package net.m14m.ardecha.application;

import net.m14m.ardecha.characters.TranslatableCharacter;
import net.m14m.ardecha.input.*;
import net.m14m.ardecha.output.*;
import org.junit.*;

import java.io.IOException;

public class TranslationIoCoordinatorTest {
    private static final String FILE_CONTENTS = "abc";
    private static final String FILENAME = "sample.txt";
    private FakeInputRepository repository = new FakeInputRepository();
    private FakeOutput output = new FakeOutput();
    private TranslationIoCoordinator ioCoordinator;

    @Before public void setUpIoCoordinator() {
        ioCoordinator = new TranslationIoCoordinator(repository, output, new IdentityTranslator());
    }

    @Before public void setUpFile() {
        repository.createFile(FILENAME, FILE_CONTENTS);
    }

    @Test public void shouldPrintRot13edInputToOutput() throws IOException {
        ioCoordinator.translate(FILENAME);
        output.shouldHavePrinted(FILE_CONTENTS);
    }

    private class IdentityTranslator implements Translator {
        public void translate(Input input, Output output) {
            for (TranslatableCharacter character : input) {
                output.writeChar(character);
            }
        }
    }
}
