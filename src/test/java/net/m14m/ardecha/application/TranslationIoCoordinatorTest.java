package net.m14m.ardecha.application;

import net.m14m.ardecha.input.FakeInputRepository;
import net.m14m.ardecha.output.FakeOutput;
import org.junit.*;

import java.io.IOException;

public class TranslationIoCoordinatorTest {
    private static final String FILENAME = "sample.txt";
    private FakeInputRepository repository = new FakeInputRepository();
    private FakeOutput output = new FakeOutput();
    private TranslationIoCoordinator translator = new TranslationIoCoordinator(repository, output);

    @Test public void shouldPrintRot13edInputToOutput() throws IOException {
        repository.createFile(FILENAME, "abc");
        translator.translate(FILENAME);
        output.shouldHavePrinted("nop");
    }
}
