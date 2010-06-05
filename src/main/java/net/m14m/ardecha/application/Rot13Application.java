package net.m14m.ardecha.application;

import net.m14m.ardecha.characters.TranslatableCharacter;
import net.m14m.ardecha.input.*;
import net.m14m.ardecha.output.*;

import java.io.PrintWriter;

public class Rot13Application {
    private final InputRepository repository;
    private final Output output;
    private final ErrorLogger errorLogger;

    public static void main(String... args) {
        InputRepository repository = FilesystemBackedInputRepository.create();
        PrintStreamOutput output = new PrintStreamOutput(System.out);
        ErrorLogger errorLogger = new ErrorLogger(new PrintWriter(System.out));
        new Rot13Application(repository, output, errorLogger).translate(args[0]);
    }

    public Rot13Application(InputRepository repository, Output output, ErrorLogger errorLogger) {
        this.repository = repository;
        this.output = output;
        this.errorLogger = errorLogger;
    }

    public void translate(String inputFilename) {
        try {
            for (TranslatableCharacter character : repository.load(inputFilename)) {
                output.writeChar(character);
            }
        } catch (Exception e) {
            errorLogger.log(e);
        }
    }
}
