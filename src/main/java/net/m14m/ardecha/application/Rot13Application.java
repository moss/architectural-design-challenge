package net.m14m.ardecha.application;

import net.m14m.ardecha.characters.TranslatableCharacter;
import net.m14m.ardecha.input.*;
import net.m14m.ardecha.output.*;

public class Rot13Application {
    private final InputRepository repository;
    private final Output output;

    public static void main(String... args) {
        new Rot13Application(new FilesystemBackedInputRepository(), new SystemOutput())
                .translate(args[0]);
    }

    public Rot13Application(InputRepository repository, Output output) {
        this.repository = repository;
        this.output = output;
    }

    public void translate(String inputFilename) {
        for (Integer character : repository.load(inputFilename)) {
            output.writeChar(new TranslatableCharacter(character));
        }
    }
}
