package net.m14m.ardecha.application;

import org.junit.*;

import java.io.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ErrorLoggerTest {
    private StringWriter outputWriter = new StringWriter();
    private ErrorLogger errorLogger;

    @Before public void setUp() throws Exception {
        errorLogger = new ErrorLogger(new PrintWriter(outputWriter));
    }

    @Test @SuppressWarnings({"ThrowableInstanceNeverThrown"}) public void
    shouldPrintAMessageAboutTheError() {
        errorLogger.log(new RuntimeException("I haz a ouch."));
        String output = outputWriter.toString();
        assertThat("Should start with readable message", output, startsWith("An error occurred."));
        assertThat("Should include the exception", output, containsString("RuntimeException"));
        assertThat("Should include the exception message", output, containsString("I haz a ouch"));
    }
}
