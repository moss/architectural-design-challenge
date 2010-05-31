package net.m14m.ardecha.application;

import net.m14m.ardecha.input.InputRepository;
import net.m14m.ardecha.output.Output;

public class Rot13Application {
    private final InputRepository repository;
    private final Output output;

    public Rot13Application(InputRepository repository, Output output) {
        this.repository = repository;
        this.output = output;
    }

    public void translate(String inputFilename) {
        for (Integer character : repository.load(inputFilename)) {
            output.writeChar(character);
        }
    }
}
