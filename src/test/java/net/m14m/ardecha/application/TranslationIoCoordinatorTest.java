package net.m14m.ardecha.application;

import net.m14m.ardecha.input.FakeInputRepository;
import net.m14m.ardecha.output.FakeOutput;
import org.junit.*;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class TranslationIoCoordinatorTest {
    private static final String FILENAME = "sample.txt";
    private FakeInputRepository repository = new FakeInputRepository();
    private FakeOutput output = new FakeOutput();
    private Rot13Translator translator;
    private TranslationIoCoordinator ioCoordinator;

    @Before public void setUpIoCoordinator() {
        translator = mock(Rot13Translator.class);
        ioCoordinator = new TranslationIoCoordinator(repository, output, translator);
    }

    @Test public void shouldPrintRot13edInputToOutput() throws IOException {
        repository.createFile(FILENAME, "abc");
        ioCoordinator.translate(FILENAME);
        verify(translator).translate(repository.load(FILENAME), output);
    }
}
