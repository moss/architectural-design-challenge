package net.m14m.ardecha.input;

import org.junit.*;

import java.io.IOException;
import java.util.Iterator;

import static org.junit.Assert.*;

public abstract class InputRepositoryContract {
    private static final String FILENAME = "some_file.txt";

    @Before public void writeContentsOfFile() throws IOException {
        writeFile(FILENAME, "test");
    }

    protected abstract void writeFile(String filename, String contents) throws IOException;

    @Test public void shouldReadTheSpecifiedFileFromTheFilesystem() {
        InputRepository repository = getRepository();
        Iterator<Integer> inputIterator = repository.load(FILENAME).iterator();
        assertEquals(new Integer('t'), inputIterator.next());
        assertEquals(new Integer('e'), inputIterator.next());
        assertEquals(new Integer('s'), inputIterator.next());
        assertEquals(new Integer('t'), inputIterator.next());
    }

    protected abstract InputRepository getRepository();

    @After public void cleanUpFile() {
        deleteFile(FILENAME);
    }

    protected abstract void deleteFile(String filename);
}
