package net.m14m.ardecha.output;

import java.io.IOException;

public class ConsoleAndFileOutputRepository implements OutputFileRepository {
    private final OutputFileRepository repository;
    private final Output standardOutput;

    public ConsoleAndFileOutputRepository(OutputFileRepository repository, Output standardOutput) {
        this.repository = repository;
        this.standardOutput = standardOutput;
    }

    public Output create(String outputFilename) throws IOException {
        Output fileOutput = repository.create(outputFilename);
        return new MultipleOutput(standardOutput, fileOutput);
    }
}