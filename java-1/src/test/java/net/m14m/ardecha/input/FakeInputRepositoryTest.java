package net.m14m.ardecha.input;

import java.io.IOException;

public class FakeInputRepositoryTest extends InputRepositoryContract {
    private FakeInputRepository fakeInputRepository = new FakeInputRepository();

    @Override protected void writeFile(String filename, String contents) throws IOException {
        fakeInputRepository.createFile(filename, contents);
    }

    @Override protected InputRepository getRepository() {
        return fakeInputRepository;
    }

    @Override protected void deleteFile(String filename) {
        // nothing to do for the fake version
    }
}
