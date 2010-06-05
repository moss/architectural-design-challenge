package net.m14m.ardecha.acceptance;

import net.m14m.ardecha.application.*;
import net.m14m.ardecha.input.FakeInputRepository;
import net.m14m.ardecha.output.FakeOutput;

import java.io.*;

import static org.mockito.Mockito.*;

public class FakeIOEnvironment {
    private final FakeInputRepository repository;
    private final FakeOutput output;

    public FakeIOEnvironment() {
        repository = new FakeInputRepository();
        output = new FakeOutput();
    }

    public FakeInputRepository getRepository() {
        return repository;
    }

    public FakeOutput getOutput() {
        return output;
    }

    public Rot13Application createApplicationInFakeEnvironment() {
        PrintWriter ouputWriter = new PrintWriter(new StringWriter());
        ErrorLogger logger = new ErrorLogger(ouputWriter);
        Flushable dummyFlushable = mock(Flushable.class);
        Rot13Translator translator = new Rot13Translator(repository, output);
        return new Rot13Application(translator, logger, dummyFlushable);
    }
}