package net.m14m.ardecha_end_to_end_tests;

import net.m14m.ardecha.Rot13Application;
import org.junit.*;

import java.io.*;

import static org.apache.commons.io.FileUtils.*;
import static org.junit.Assert.*;

public class EndToEndTest {
    private static final File TEST_IO_DIRECTORY = new File("test-io-directory");
    private PrintStream realSystemOut;
    private ByteArrayOutputStream fakeSystemOut = new ByteArrayOutputStream();

    @Test public void shouldPrintTheRot13dTextOfTheFile() throws Exception {
        givenAFile("in.txt", "The dog barks at midnight.");
        whenIRunTheRot13CommandWith("in.txt", "ignored-output.txt");
        thenTheScreenShouldDisplay("Gur qbt onexf ng zvqavtug.");
    }

    private void givenAFile(String name, String content) throws Exception {
        writeStringToFile(new File(TEST_IO_DIRECTORY, name), content);
    }

    private void whenIRunTheRot13CommandWith(String... args) {
        Rot13Application.main(args);
    }

    private void thenTheScreenShouldDisplay(String expectedOutput) throws Exception {
        assertEquals("output to screen", expectedOutput, fakeSystemOut.toString("UTF-8"));
    }

    @Before public void replaceSystemOut() {
        realSystemOut = System.out;
        System.setOut(new PrintStream(fakeSystemOut));
    }

    @After public void restoreSystemOut() {
        System.setOut(realSystemOut);
    }

    @Before public void setUpTestIoDirectory() throws IOException {
        forceMkdir(TEST_IO_DIRECTORY);
        System.setProperty("io-directory", TEST_IO_DIRECTORY.getName());
    }

    @After public void clearTestIoDirectory() throws IOException {
        deleteDirectory(TEST_IO_DIRECTORY);
    }
}
