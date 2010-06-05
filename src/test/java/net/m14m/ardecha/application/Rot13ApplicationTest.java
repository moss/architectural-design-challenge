package net.m14m.ardecha.application;

import net.m14m.ardecha.input.FakeInputRepository;
import net.m14m.ardecha.output.FakeOutput;
import org.junit.*;
import org.mockito.*;

import java.io.*;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

public class Rot13ApplicationTest {
    private static final String FILENAME = "sample.txt";
    private FakeInputRepository repository = new FakeInputRepository();
    private FakeOutput output = new FakeOutput();
    @Mock private ErrorLogger errorLogger;
    @Mock private Flushable systemOutput;
    private Rot13Application application;

    @Before public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        application = new Rot13Application(repository, output, errorLogger, systemOutput);
    }

    @Test public void shouldPrintInputToOutput() throws IOException {
        repository.createFile(FILENAME, "some text");
        application.translate(FILENAME);
        output.shouldHavePrinted("some text");
    }

    @Test @SuppressWarnings({"ThrowableResultOfMethodCallIgnored"}) public void
    shouldCatchAndLogExceptions() throws IOException {
        application.translate("nonexistent-file.txt");
        verify(errorLogger).log(isA(FileNotFoundException.class));
    }

    @Test public void shouldFlushSystemOutputWhenItFinishesRunning() throws IOException {
        repository.createFile(FILENAME, "");
        application.translate(FILENAME);
        verify(systemOutput).flush();
    }

    @Test public void shouldFlushOutputEvenIfThereIsAnError() throws IOException {
        application.translate("nonexistent-file.txt");
        verify(systemOutput).flush();
    }
}
