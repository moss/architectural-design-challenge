package net.m14m.ardecha;

import net.m14m.ardecha.testing_support.FilesystemTestFixture;
import org.junit.*;

import java.io.IOException;

import static net.m14m.ardecha.testing_support.FilesystemTestFixture.TEST_IO_DIRECTORY;

public class FileOutputIntegrationTest {
    private FilesystemTestFixture filesystem = new FilesystemTestFixture();

    @Test public void shouldWriteOutputToAFile() throws Exception {
        FileOutput output = FileOutput.open(TEST_IO_DIRECTORY, "testfile.txt");
        output.write('a');
        output.write('b');
        output.write('c');

        filesystem.thenAFileShouldBeCreated("testfile.txt", "abc");
    }

    @Before public void setUpFilesystemFixture() throws IOException {
        filesystem.setUpTestIoDirectory();
    }

    @After public void tearDownFilesystemFixture() throws IOException {
        filesystem.clearTestIoDirectory();
    }
}
