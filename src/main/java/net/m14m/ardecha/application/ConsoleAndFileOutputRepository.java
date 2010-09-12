package net.m14m.ardecha.application;

import net.m14m.ardecha.output.*;

import java.io.IOException;

public class ConsoleAndFileOutputRepository implements OutputFileRepository {
    private final OutputFileRepository outputRepository;
    private final Output standardOutput;

    public ConsoleAndFileOutputRepository(OutputFileRepository outputRepository,
                                          Output standardOutput) {
        this.outputRepository = outputRepository;
        this.standardOutput = standardOutput;
    }

    public Output create(String outputFilename) throws IOException {
        Output fileOutput = outputRepository.create(outputFilename);
        return new MultipleOutput(standardOutput, fileOutput);
    }
}