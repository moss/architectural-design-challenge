package net.m14m.ardecha.output;

import net.m14m.ardecha.testing_support.FilesystemTestFixture;
import org.junit.*;

import static net.m14m.ardecha.testing_support.FilesystemTestFixture.TEST_IO_DIRECTORY;

public class FileOutputIntegrationTest {
    @Rule public FilesystemTestFixture filesystem = new FilesystemTestFixture();

    @Test public void shouldWriteOutputToAFile() throws Exception {
        FileOutput output = FileOutput.open(TEST_IO_DIRECTORY, "testfile.txt");
        output.write('a');
        output.write('b');
        output.write('c');

        filesystem.thenAFileShouldBeCreated("testfile.txt", "abc");
    }
}
