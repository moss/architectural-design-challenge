package net.m14m.ardecha.output;

import net.m14m.ardecha.characters.TranslatableCharacter;
import org.junit.*;

import java.io.*;

public abstract class OutputFileRepositoryContract {
    protected static final String OUTPUT_DIR = "output-dir-for-integration-tests";
    protected static final String OUTPUT_FILE = "output.txt";

    @Test public void shouldWriteOutputToAFileInTheFilesystem() throws IOException {
        Output output = getRepository().create(OUTPUT_FILE);
        output.writeChar(new TranslatableCharacter('a'));
        output.writeChar(new TranslatableCharacter('b'));
        output.writeChar(new TranslatableCharacter('c'));

        checkContents(OUTPUT_FILE, "abc");
    }

    protected abstract OutputFileRepository getRepository();

    protected abstract void checkContents(String filename, String expectedContents) throws FileNotFoundException;
}
