package net.m14m.ardecha.input;

import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.*;

public abstract class InputRepositoryContract {
    private static final String FILENAME = "some_file.txt";

    @Before public void writeContentsOfFile() throws IOException {
        writeFile(FILENAME, "test");
    }

    protected abstract void writeFile(String filename, String contents) throws IOException;

    @Test public void shouldReadTheSpecifiedFileFromTheFilesystem() {
        InputRepository repository = getRepository();
        Input input = repository.load(FILENAME);
        assertEquals('t', input.readChar());
        assertEquals('e', input.readChar());
        assertEquals('s', input.readChar());
        assertEquals('t', input.readChar());
    }

    protected abstract InputRepository getRepository();

    @After public void cleanUpFile() {
        deleteFile(FILENAME);
    }

    protected abstract void deleteFile(String filename);
}
