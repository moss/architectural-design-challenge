package net.m14m.ardecha.input;

import org.junit.*;

import java.io.*;

import static net.m14m.ardecha.input.InputAssertions.assertHasCharacters;

public abstract class InputRepositoryContract {
    protected static final String FILENAME = "some_file.txt";

    @Before public void writeContentsOfFile() throws IOException {
        writeFile(FILENAME, "test");
    }

    protected abstract void writeFile(String filename, String contents) throws IOException;

    @Test public void shouldReadTheSpecifiedFileFromTheFilesystem() throws FileNotFoundException {
        InputRepository repository = getRepository();
        Input input = repository.load(FILENAME);
        assertHasCharacters(input, 't', 'e', 's', 't');
    }

    @Test(expected = FileNotFoundException.class) public void
    shouldThrowFileNotFoundExceptionIfFileIsNotFound() throws FileNotFoundException {
        getRepository().load("nonexistent_file.txt");
    }

    protected abstract InputRepository getRepository();

    @After public void cleanUpFile() {
        deleteFile(FILENAME);
    }

    protected abstract void deleteFile(String filename);
}
