package net.m14m.ardecha.output;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class SystemOutputTest {
    private PrintStream realSystemOut;
    private ByteArrayOutputStream fakeSystemOut;

    @Before public void replaceSystemOut() throws Exception {
        realSystemOut = System.out;
        fakeSystemOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeSystemOut));
    }

    @Test public void shouldPrintCharacters() throws UnsupportedEncodingException {
        Output output = getOutput();
        output.writeChar('t');
        output.writeChar('e');
        output.writeChar('s');
        output.writeChar('t');
        shouldHavePrinted("test");
    }

    private void shouldHavePrinted(String expectedOutput) throws UnsupportedEncodingException {
        assertEquals(expectedOutput, fakeSystemOut.toString("utf-8"));
    }

    private Output getOutput() {
        return new SystemOutput();
    }

    @After public void restoreSystemOut() {
        System.setOut(realSystemOut);
    }
}
