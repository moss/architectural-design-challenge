package net.m14m.ardecha.application;

import net.m14m.ardecha.input.InputRepository;
import net.m14m.ardecha.output.Output;

import java.io.FileNotFoundException;

public class TranslationIoCoordinator {
    private final InputRepository repository;
    private final Output output;
    private final Translator translator;

    public TranslationIoCoordinator(InputRepository repository, Output output,
                                    Translator translator) {
        this.repository = repository;
        this.output = output;
        this.translator = translator;
    }

    public void translate(String inputFilename, String outputFilename)
            throws FileNotFoundException {
        translator.translate(repository.load(inputFilename), output);
    }
}