package net.m14m.ardecha.application;

import org.hamcrest.Matcher;
import org.junit.*;

import java.io.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SuppressWarnings({"ThrowableInstanceNeverThrown"})
public class ErrorLoggerTest {
    private static final String GENERIC_ERROR_MESSAGE = "An error occurred.";
    private StringWriter outputWriter = spy(new StringWriter());
    private ErrorLogger errorLogger;

    @Before public void setUp() throws Exception {
        errorLogger = new ErrorLogger(new PrintWriter(outputWriter));
    }

    @Test public void shouldPrintAMessageAboutTheError() {
        errorLogger.log(new RuntimeException("I haz a ouch."));
        outputShouldStartWith("readable message", GENERIC_ERROR_MESSAGE);
        outputShouldContain("the exception", "RuntimeException");
        outputShouldContain("the exception message", "I haz a ouch");
    }

    @Test public void shouldFormatFileNotFoundExceptionsWithAFriendlyErrorMessage() {
        errorLogger.log(new FileNotFoundException("dir/badfile (No such file or directory)"));
        outputShouldNotContain("the generic message", GENERIC_ERROR_MESSAGE);
        outputShouldNotContain("a stack trace", "at java.");
        outputShouldContain("a meaningful message",
                "File not found: dir/badfile (No such file or directory)");
    }

    private void outputShouldStartWith(String roleOfText, String expectedText) {
        ensureThatOutput("start with " + roleOfText, startsWith(expectedText));
    }

    private void outputShouldContain(String roleOfText, String expectedText) {
        ensureThatOutput("include " + roleOfText, containsString(expectedText));
    }

    private void outputShouldNotContain(String roleOfText, String expectedAbsentText) {
        ensureThatOutput("not include " + roleOfText, not(containsString(expectedAbsentText)));
    }

    private void ensureThatOutput(String requirement, Matcher<String> matcher) {
        assertThat("Output should " + requirement, outputWriter.toString(), matcher);
    }
}
