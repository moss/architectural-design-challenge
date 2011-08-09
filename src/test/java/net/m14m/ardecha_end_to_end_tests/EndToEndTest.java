package net.m14m.ardecha_end_to_end_tests;

import net.m14m.ardecha.Rot13Application;
import net.m14m.ardecha.testing_support.FilesystemTestFixture;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class EndToEndTest {
    private final FilesystemTestFixture filesystem = new FilesystemTestFixture();
    private PrintStream realSystemOut;
    private ByteArrayOutputStream fakeSystemOut = new ByteArrayOutputStream();

    @Test public void shouldPrintTheRot13dTextOfTheFile() throws Exception {
        givenAFile("in.txt", "The dog barks at midnight.");
        whenIRunTheRot13CommandWith("in.txt", "ignored-output.txt");
        thenTheScreenShouldDisplay("Gur qbt onexf ng zvqavtug.");
    }

    private void givenAFile(String name, String content) throws Exception {
        filesystem.givenAFile(name, content);
    }

    private void whenIRunTheRot13CommandWith(String... args) {
        Rot13Application.main(args);
    }

    private void thenTheScreenShouldDisplay(String expectedOutput) throws Exception {
        assertEquals("output to screen", expectedOutput, fakeSystemOut.toString("ASCII"));
    }

    @Before public void replaceSystemOut() {
        realSystemOut = System.out;
        System.setOut(new PrintStream(fakeSystemOut));
    }

    @After public void restoreSystemOut() {
        System.setOut(realSystemOut);
    }

    @Before public void setUpTestIoDirectory() throws IOException {
        filesystem.setUpTestIoDirectory();
    }

    @After public void clearTestIoDirectory() throws IOException {
        filesystem.clearTestIoDirectory();
    }
}
