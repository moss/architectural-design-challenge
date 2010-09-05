package net.m14m.ardecha.application;

import net.m14m.ardecha.input.InputRepository;
import net.m14m.ardecha.output.Output;

import java.io.FileNotFoundException;

public class TranslationIoCoordinator {
    private final InputRepository repository;
    private final Output output;
    private final Rot13Translator rot13Translator;

    public TranslationIoCoordinator(InputRepository repository, Output output,
                                    Rot13Translator rot13Translator) {
        this.repository = repository;
        this.output = output;
        this.rot13Translator = rot13Translator;
    }

    public void translate(String inputFilename) throws FileNotFoundException {
        rot13Translator.translate(repository.load(inputFilename), output);
    }
}