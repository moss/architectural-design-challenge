package net.m14m.ardecha.output;

import net.m14m.ardecha.characters.TranslatableCharacter;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SystemOutputTest extends OutputContract {
    private PrintStream realSystemOut;
    private ByteArrayOutputStream fakeSystemOut;

    @Before public void replaceSystemOut() throws Exception {
        realSystemOut = System.out;
        fakeSystemOut = spy(new ByteArrayOutputStream());
        System.setOut(new PrintStream(fakeSystemOut));
    }

    @Override protected Output getOutput() {
        return new SystemOutput(System.out);
    }

    @Override protected void shouldHavePrinted(String expectedOutput) throws UnsupportedEncodingException {
        assertEquals(expectedOutput, fakeSystemOut.toString("utf-8"));
    }

    @Test public void shouldFlushAfterEachCharacter_otherwiseFilesWithNoNewlineAtTheEndWillPrintWrong() throws IOException {
        getOutput().writeChar(new TranslatableCharacter('c'));
        verify(fakeSystemOut).flush();
    }

    @After public void restoreSystemOut() {
        System.setOut(realSystemOut);
    }
}
