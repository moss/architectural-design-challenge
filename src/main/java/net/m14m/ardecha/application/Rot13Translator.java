package net.m14m.ardecha.application;

import net.m14m.ardecha.characters.TranslatableCharacter;
import net.m14m.ardecha.input.InputRepository;
import net.m14m.ardecha.output.Output;

import java.io.FileNotFoundException;

public class Rot13Translator {
    private final InputRepository repository;
    private final Output output;

    public Rot13Translator(InputRepository repository, Output output) {
        this.repository = repository;
        this.output = output;
    }

    public void translate(String inputFilename) throws FileNotFoundException {
        for (TranslatableCharacter character : repository.load(inputFilename)) {
            output.writeChar(character.translate());
        }
    }
}