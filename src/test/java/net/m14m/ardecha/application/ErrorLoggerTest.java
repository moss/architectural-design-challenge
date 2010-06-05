package net.m14m.ardecha.application;

import org.junit.*;

import java.io.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SuppressWarnings({"ThrowableInstanceNeverThrown"})
public class ErrorLoggerTest {
    private StringWriter outputWriter = spy(new StringWriter());
    private ErrorLogger errorLogger;

    @Before public void setUp() throws Exception {
        errorLogger = new ErrorLogger(new PrintWriter(outputWriter));
    }

    @Test public void shouldPrintAMessageAboutTheError() {
        errorLogger.log(new RuntimeException("I haz a ouch."));
        String output = outputWriter.toString();
        assertThat("Should start with readable message", output, startsWith("An error occurred."));
        assertThat("Should include the exception", output, containsString("RuntimeException"));
        assertThat("Should include the exception message", output, containsString("I haz a ouch"));
    }

    @Test public void shouldFlushAfterOutput() {
        errorLogger.log(new RuntimeException());
        verify(outputWriter).flush();
    }
}
