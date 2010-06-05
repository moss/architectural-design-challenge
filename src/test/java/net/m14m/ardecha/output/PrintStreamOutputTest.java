package net.m14m.ardecha.output;

import net.m14m.ardecha.characters.TranslatableCharacter;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PrintStreamOutputTest extends OutputContract {
    private ByteArrayOutputStream outputStream = spy(new ByteArrayOutputStream());

    @Override protected Output getOutput() {
        return new PrintStreamOutput(new PrintStream(outputStream));
    }

    @Override protected void shouldHavePrinted(String expectedOutput) throws UnsupportedEncodingException {
        assertEquals(expectedOutput, outputStream.toString("utf-8"));
    }

    @Test public void shouldFlushAfterEachCharacter_otherwiseFilesWithNoNewlineAtTheEndWillPrintWrong() throws IOException {
        getOutput().writeChar(new TranslatableCharacter('c'));
        verify(outputStream).flush();
    }
}
