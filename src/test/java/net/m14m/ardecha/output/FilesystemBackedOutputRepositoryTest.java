package net.m14m.ardecha.output;

import net.m14m.ardecha.characters.TranslatableCharacter;
import net.m14m.ardecha.input.StringableFile;
import org.junit.*;

import java.io.*;

import static net.m14m.ardecha.testing.TestingUtilities.failUnless;
import static org.junit.Assert.*;

public class FilesystemBackedOutputRepositoryTest {
    private static final String OUTPUT_DIR = "output-dir-for-integration-tests";
    private static final String OUTPUT_FILE = "output.txt";
    private FilesystemBackedOutputRepository repository;

    @Before public void setUpRepository() throws Exception {
        repository = new FilesystemBackedOutputRepository(OUTPUT_DIR);
    }

    @Before public void setUpRepositoryDir() {
        failUnless(new File(OUTPUT_DIR).mkdir(), "Could not create repository dir");
    }

    @After public void deleteTestFile() {
        failUnless(new File(OUTPUT_DIR, OUTPUT_FILE).delete(), "Could not delete output file");
    }
    
    @After public void deleteRepositoryDir() {
        failUnless(new File(OUTPUT_DIR).delete(), "Could not delete output dir");
    }

    @Test public void shouldWriteOutputToAFileInTheFilesystem() throws IOException {
        Output output = repository.create(OUTPUT_FILE);
        output.writeChar(new TranslatableCharacter('a'));
        output.writeChar(new TranslatableCharacter('b'));
        output.writeChar(new TranslatableCharacter('c'));

        String contents = new StringableFile(new File(OUTPUT_DIR, OUTPUT_FILE)).read();
        assertEquals("abc", contents);
    }
}
