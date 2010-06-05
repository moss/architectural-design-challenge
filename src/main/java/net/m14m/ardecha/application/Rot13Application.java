package net.m14m.ardecha.application;

import net.m14m.ardecha.characters.TranslatableCharacter;
import net.m14m.ardecha.input.*;
import net.m14m.ardecha.output.*;

import java.io.*;

public class Rot13Application {
    private final InputRepository repository;
    private final Output output;
    private final ErrorLogger errorLogger;
    private final Flushable streamToFlushWhenAppFinishes;

    public static void main(String... args) throws IOException {
        InputRepository repository = FilesystemBackedInputRepository.create();
        PrintStream systemOut = System.out;
        PrintWriter writerWrappingSystemOut = new PrintWriter(systemOut);
        PrintStreamOutput output = new PrintStreamOutput(systemOut);
        ErrorLogger errorLogger = new ErrorLogger(writerWrappingSystemOut);
        new Rot13Application(repository, output, errorLogger, writerWrappingSystemOut)
                .translate(args[0]);
    }

    public Rot13Application(InputRepository repository, Output output, ErrorLogger errorLogger,
                            Flushable streamToFlushWhenAppFinishes) {
        this.repository = repository;
        this.output = output;
        this.errorLogger = errorLogger;
        this.streamToFlushWhenAppFinishes = streamToFlushWhenAppFinishes;
    }

    public void translate(String inputFilename) throws IOException {
        try {
            for (TranslatableCharacter character : repository.load(inputFilename)) {
                output.writeChar(character);
            }
        } catch (Exception e) {
            errorLogger.log(e);
        }
        streamToFlushWhenAppFinishes.flush();
    }
}
