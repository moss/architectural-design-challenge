package net.m14m.ardecha.input;

import java.io.*;

import static net.m14m.ardecha.testing.TestingUtilities.failUnless;

public class FilesystemBackedInputRepositoryTest extends InputRepositoryContract {
    private static final String INPUT_DIRECTORY_NAME = "input-dir-for-integration-tests";
    private static final File INPUT_DIRECTORY = new File(INPUT_DIRECTORY_NAME);

    @Override protected void writeFile(String filename, String contents) throws IOException {
        failUnless(INPUT_DIRECTORY.mkdir(), "Could not create input directory for test");
        FileWriter writer = new FileWriter(inputFile(filename));
        writer.write(contents);
        writer.close();
    }

    @Override protected FilesystemBackedInputRepository getRepository() {
        return new FilesystemBackedInputRepository(INPUT_DIRECTORY_NAME);
    }

    @Override protected void deleteFile(String filename) {
        failUnless(inputFile(filename).delete(), "Could not delete file after test finished");
        failUnless(INPUT_DIRECTORY.delete(), "Could not delete input directory when test finished");
    }

    private File inputFile(String filename) {
        return new File(INPUT_DIRECTORY, filename);
    }
}
