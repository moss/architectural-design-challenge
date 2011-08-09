package net.m14m.ardecha.testing_support;

import java.io.*;

import static org.apache.commons.io.FileUtils.*;

public class FilesystemTestFixture {
    public static final File TEST_IO_DIRECTORY = new File("test-io-directory");

    public void givenAFile(String name, String content) throws Exception {
        writeStringToFile(new File(TEST_IO_DIRECTORY, name), content);
    }

    public void setUpTestIoDirectory() throws IOException {
        forceMkdir(TEST_IO_DIRECTORY);
        System.setProperty("io-directory", TEST_IO_DIRECTORY.getName());
    }

    public void clearTestIoDirectory() throws IOException {
        deleteDirectory(TEST_IO_DIRECTORY);
    }
}