package net.m14m.ardecha.input;

import net.m14m.ardecha.*;
import net.m14m.ardecha.testing_support.*;
import org.junit.*;

import static net.m14m.ardecha.testing_support.FilesystemTestFixture.TEST_IO_DIRECTORY;

public class DirectoryBackedFileRepositoryIntegrationTest {
    @Rule public final FilesystemTestFixture filesystem = new FilesystemTestFixture();
    private FileRepository repository = new DirectoryBackedFileRepository(TEST_IO_DIRECTORY);

    @Test public void shouldReadAFileFromTheSpecifiedDirectory() throws Exception {
        filesystem.givenAFile("some-file.txt", "abc");
        TextFile file = repository.loadFile("some-file.txt");
        fileShouldContain("abc", file);
    }

    @Test(expected = InputException.class) public void shouldThrowASpecificExceptionOnFailure() {
        repository.loadFile("nonexistent-file.txt");
    }

    private void fileShouldContain(String expectedContent, TextFile file) {
        TestableOutput output = new TestableOutput();
        file.writeTo(output);
        output.shouldEqual(expectedContent);
    }
}
