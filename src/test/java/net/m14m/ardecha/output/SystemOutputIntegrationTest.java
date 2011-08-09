package net.m14m.ardecha.output;

import net.m14m.ardecha.Output;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class SystemOutputIntegrationTest {
    private PrintStream realSystemOut;
    private ByteArrayOutputStream fakeSystemOut = new ByteArrayOutputStream();
    private Output output = new SystemOutput();

    @Test public void shouldPassItsOutputOnToSystemOut() throws UnsupportedEncodingException {
        output.write('a');
        output.write('b');
        output.write('c');

        assertEquals("abc", fakeSystemOut.toString("ASCII"));
    }

    @Before public void replaceSystemOut() {
        realSystemOut = System.out;
        System.setOut(new PrintStream(fakeSystemOut));
    }

    @After public void restoreSystemOut() {
        System.setOut(realSystemOut);
    }
}
