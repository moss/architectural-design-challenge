package net.m14m.ardecha.application;

import net.m14m.ardecha.input.*;
import net.m14m.ardecha.output.*;

import java.io.IOException;

public class TranslationIoCoordinator {
    private final InputRepository inputRepository;
    private final Translator translator;
    private final OutputFileRepository outputRepository;

    public TranslationIoCoordinator(InputRepository inputRepository,
                                    OutputFileRepository outputRepository,
                                    Translator translator) {
        this.inputRepository = inputRepository;
        this.outputRepository = outputRepository;
        this.translator = translator;
    }

    public void translate(String inputFilename, String outputFilename) throws IOException {
        Input input = inputRepository.load(inputFilename);
        Output output = outputRepository.create(outputFilename);
        translator.translate(input, output);
    }
}