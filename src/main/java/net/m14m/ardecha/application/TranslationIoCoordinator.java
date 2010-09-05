package net.m14m.ardecha.application;

import net.m14m.ardecha.input.*;
import net.m14m.ardecha.output.*;

import java.io.IOException;

public class TranslationIoCoordinator {
    private final InputRepository inputRepository;
    private final OutputFileRepository outputRepository;
    private final Output standardOutput;
    private final Translator translator;

    public TranslationIoCoordinator(InputRepository inputRepository,
                                    OutputFileRepository outputRepository, Output standardOutput,
                                    Translator translator) {
        this.inputRepository = inputRepository;
        this.outputRepository = outputRepository;
        this.standardOutput = standardOutput;
        this.translator = translator;
    }

    public void translate(String inputFilename, String outputFilename)
            throws IOException {
        Input input = inputRepository.load(inputFilename);
        Output fileOutput = outputRepository.create(outputFilename);
        MultipleOutput output = new MultipleOutput(standardOutput, fileOutput);
        translator.translate(input, output);
    }
}