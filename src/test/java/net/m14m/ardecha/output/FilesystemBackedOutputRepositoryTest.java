package net.m14m.ardecha.output;

import net.m14m.ardecha.input.StringableFile;
import org.junit.*;

import java.io.*;

import static net.m14m.ardecha.testing.TestingUtilities.failUnless;
import static org.junit.Assert.*;

public class FilesystemBackedOutputRepositoryTest extends OutputFileRepositoryContract {
    private FilesystemBackedOutputRepository repository = new FilesystemBackedOutputRepository(OUTPUT_DIR);

    @Override protected FilesystemBackedOutputRepository getRepository() {
        return repository;
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

    @Override protected void checkContents(String filename, String expectedContents) throws FileNotFoundException {
        String contents = new StringableFile(new File(OUTPUT_DIR, filename)).read();
        assertEquals(expectedContents, contents);
    }
}
