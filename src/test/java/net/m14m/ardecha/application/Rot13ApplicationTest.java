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
    @Mock private Rot13Translator translator;
    private Rot13Application application;

    @Before public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        application = new Rot13Application(translator, errorLogger, systemOutput);
    }

    @Test public void shouldTranslateTheSpecifiedFile() throws IOException {
        application.run("filename", "");
        verify(translator).translate("filename");
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

    private void givenAnErrorInTheApplication(Exception error) throws FileNotFoundException {
        doThrow(error).when(translator).translate(anyString());
    }
}
