package net.m14m.ardecha.acceptance;

import net.m14m.ardecha.application.Rot13Application;
import net.m14m.ardecha.input.FakeFileRepository;
import net.m14m.ardecha.output.*;

public class FakeIOEnvironment {
    private final FakeFileRepository repository;
    private final FakeOutput output;

    public FakeIOEnvironment() {
        repository = new FakeFileRepository();
        output = new FakeOutput();
    }

    public FakeFileRepository getRepository() {
        return repository;
    }

    public Output getOutput() {
        return output;
    }

    public Rot13Application createApplicationInFakeEnvironment() {
        return new Rot13Application(repository, output);
    }
}