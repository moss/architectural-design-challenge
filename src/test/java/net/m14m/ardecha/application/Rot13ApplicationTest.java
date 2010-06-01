package net.m14m.ardecha.application;

import net.m14m.ardecha.input.FakeInputRepository;
import net.m14m.ardecha.output.FakeOutput;
import org.junit.*;

import java.io.FileNotFoundException;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

public class Rot13ApplicationTest {
    private static final String FILENAME = "sample.txt";
    private FakeInputRepository repository = new FakeInputRepository();
    private FakeOutput output = new FakeOutput();
    private ErrorLogger errorLogger;
    private Rot13Application application;

    @Before public void setUp() throws Exception {
        errorLogger = mock(ErrorLogger.class);
        application = new Rot13Application(repository, output, errorLogger);
    }

    @Test public void shouldPrintInputToOutput() {
        repository.createFile(FILENAME, "some text");
        application.translate(FILENAME);
        output.shouldHavePrinted("some text");
    }


    @Test @SuppressWarnings({"ThrowableResultOfMethodCallIgnored"}) public void 
    shouldCatchAndLogExceptions() {
        application.translate("nonexistent-file.txt");
        verify(errorLogger).log(isA(FileNotFoundException.class));
    }

}
