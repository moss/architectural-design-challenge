package net.m14m.ardecha;

import net.m14m.ardecha.testing_support.*;
import org.junit.*;

import java.io.IOException;

public class DirectoryBackedFileRepositoryIntegrationTest {
    private final FilesystemTestFixture filesystem = new FilesystemTestFixture();
    private TestableOutput output = new TestableOutput();
    private DirectoryBackedFileRepository repository;

    @Test public void shouldReadAFileFromTheSpecifiedDirectory() throws Exception {
        filesystem.givenAFile("some-file.txt", "abc");
        TextFile file = repository.loadFile("some-file.txt");
        file.writeTo(output);
        output.shouldEqual("abc");
    }

    @Before public void setUpTestIoDirectory() throws IOException {
        filesystem.setUpTestIoDirectory();
        repository = new DirectoryBackedFileRepository(FilesystemTestFixture.TEST_IO_DIRECTORY);
    }

    @After public void clearTestIoDirectory() throws IOException {
        filesystem.clearTestIoDirectory();
    }

}
