package net.m14m.ardecha.application;

import org.junit.*;
import org.mockito.*;

import java.io.*;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

@SuppressWarnings({"ThrowableInstanceNeverThrown", "ThrowableResultOfMethodCallIgnored"})
public class Rot13ApplicationTest {
    @Mock private ErrorLogger errorLogger;
    @Mock private Flushable systemOutput;
    @Mock private TranslationIoCoordinator ioCoordinator;
    private Rot13Application application;

    @Before public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        application = new Rot13Application(ioCoordinator, errorLogger, systemOutput);
    }

    @Test public void shouldTranslateTheSpecifiedFileToTheSpecifiedOutput() throws IOException {
        application.run("input-filename", "output-filename");
        verify(ioCoordinator).translate("input-filename", "output-filename");
    }

    @Test public void shouldCatchAndLogExceptions() throws IOException {
        givenAnErrorInTheApplication(new FileNotFoundException());
        application.run("", "");
        verify(errorLogger).log(isA(FileNotFoundException.class));
    }

    @Test public void shouldFlushSystemOutputWhenItFinishesRunning() throws IOException {
        application.run("", "");
        verify(systemOutput).flush();
    }

    @Test public void shouldFlushOutputEvenIfThereIsAnError() throws IOException {
        givenAnErrorInTheApplication(new RuntimeException());
        application.run("", "");
        verify(systemOutput).flush();
    }

    private void givenAnErrorInTheApplication(Exception error) throws IOException {
        doThrow(error).when(ioCoordinator).translate(anyString(), anyString());
    }
}
