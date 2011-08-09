package net.m14m.ardecha.testing_support;

import org.junit.rules.*;

import java.io.*;

import static org.junit.Assert.*;

public class SystemOutFixture extends ExternalResource {
    private PrintStream realSystemOut;
    private ByteArrayOutputStream fakeSystemOut = new ByteArrayOutputStream();

    public void thenTheScreenShouldDisplay(String expectedOutput) throws Exception {
        assertEquals("output to screen", expectedOutput, fakeSystemOut.toString("ASCII"));
    }

    @Override protected void before() throws Throwable {
        realSystemOut = System.out;
        System.setOut(new PrintStream(fakeSystemOut));
    }

    @Override protected void after() {
        System.setOut(realSystemOut);
    }
}
