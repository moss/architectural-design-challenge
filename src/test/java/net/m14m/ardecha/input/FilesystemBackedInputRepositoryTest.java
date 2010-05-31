package net.m14m.ardecha.input;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class FilesystemBackedInputRepositoryTest {
    private static final String FILENAME = "some_file.txt";

    @Before public void writeContentsOfFile() throws IOException {
        writeFile(FILENAME, "test");
    }

    private void writeFile(String filename, String contents) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(contents);
        writer.close();
    }

    @Test public void shouldReadTheSpecifiedFileFromTheFilesystem() {
        FilesystemBackedInputRepository repository = createRepository();
        Input input = repository.load(FILENAME);
        assertEquals('t', input.readChar());
        assertEquals('e', input.readChar());
        assertEquals('s', input.readChar());
        assertEquals('t', input.readChar());
    }

    private FilesystemBackedInputRepository createRepository() {
        return new FilesystemBackedInputRepository();
    }

    @After public void cleanUpFile() {
        deleteFile(FILENAME);
    }

    private void deleteFile(String filename) {
        //noinspection ResultOfMethodCallIgnored
        new File(filename).delete();
    }
}
