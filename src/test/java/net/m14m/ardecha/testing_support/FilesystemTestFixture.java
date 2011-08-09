package net.m14m.ardecha.testing_support;

import org.junit.rules.*;

import java.io.*;

import static org.apache.commons.io.FileUtils.*;
import static org.junit.Assert.*;

public class FilesystemTestFixture extends ExternalResource {
    public static final File TEST_IO_DIRECTORY = new File("test-io-directory");

    public void givenAFile(String name, String content) throws Exception {
        writeStringToFile(file(name), content);
    }

    public void thenAFileShouldBeCreated(String name, String expectedContent) throws Exception {
        String actualContent = readFileToString(file(name));
        assertEquals("content of file " + name, expectedContent, actualContent);
    }

    public File file(String name) {
        return new File(TEST_IO_DIRECTORY, name);
    }

    @Override protected void before() throws IOException {
        forceMkdir(TEST_IO_DIRECTORY);
        System.setProperty("io-directory", TEST_IO_DIRECTORY.getName());
    }

    @Override protected void after() {
        try {
            deleteDirectory(TEST_IO_DIRECTORY);
        } catch (IOException e) {
            // ignore it -- we don't really care
        }
    }
}