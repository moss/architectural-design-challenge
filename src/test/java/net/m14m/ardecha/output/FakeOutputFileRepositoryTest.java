package net.m14m.ardecha.output;

public class FakeOutputFileRepositoryTest extends OutputFileRepositoryContract {
    private FakeOutputFileRepository repository = new FakeOutputFileRepository();

    @Override protected OutputFileRepository getRepository() {
        return repository;
    }

    @Override protected void checkContents(String filename, String expectedContents) {
        repository.shouldContainFile(filename, expectedContents);
    }
}
