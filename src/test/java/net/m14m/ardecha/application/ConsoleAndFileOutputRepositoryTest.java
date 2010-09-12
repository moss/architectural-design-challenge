package net.m14m.ardecha.application;

import net.m14m.ardecha.characters.TranslatableCharacter;
import net.m14m.ardecha.output.*;
import org.junit.*;

import java.io.IOException;

public class ConsoleAndFileOutputRepositoryTest {
    private FakeOutputFileRepository fileOutputRepository = new FakeOutputFileRepository();
    private FakeOutput standardOutput = new FakeOutput();
    private ConsoleAndFileOutputRepository repository;

    @Before public void setUpRepository() {
        repository = new ConsoleAndFileOutputRepository(fileOutputRepository, standardOutput);
    }

    @Test public void alwaysCopiesToStandardOutput() throws IOException {
        repository.create("file1").writeChar(new TranslatableCharacter('a'));
        repository.create("file2").writeChar(new TranslatableCharacter('b'));
        standardOutput.shouldHavePrinted("ab");
    }

    @Test public void alsoWritesToTheFilesystem() throws IOException {
        repository.create("file1").writeChar(new TranslatableCharacter('a'));
        repository.create("file2").writeChar(new TranslatableCharacter('b'));
        fileOutputRepository.shouldContainFile("file1", "a");
        fileOutputRepository.shouldContainFile("file2", "b");
    }
}
