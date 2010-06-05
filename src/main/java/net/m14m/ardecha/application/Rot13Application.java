package net.m14m.ardecha.application;

import net.m14m.ardecha.input.*;
import net.m14m.ardecha.output.*;

import java.io.*;

public class Rot13Application {
    private final Rot13Translator rot13Translator;
    private final ErrorLogger errorLogger;
    private final Flushable streamToFlushWhenAppFinishes;

    public static void main(String... args) throws IOException {
        InputRepository repository = FilesystemBackedInputRepository.create();
        PrintStream systemOut = System.out;
        PrintWriter writerWrappingSystemOut = new PrintWriter(systemOut);
        PrintStreamOutput output = new PrintStreamOutput(systemOut);
        ErrorLogger errorLogger = new ErrorLogger(writerWrappingSystemOut);
        new Rot13Application(repository, output, errorLogger, writerWrappingSystemOut)
                .run(args[0]);
    }

    public Rot13Application(InputRepository repository, Output output, ErrorLogger errorLogger,
                            Flushable streamToFlushWhenAppFinishes) {
        rot13Translator = new Rot13Translator(repository, output);
        this.errorLogger = errorLogger;
        this.streamToFlushWhenAppFinishes = streamToFlushWhenAppFinishes;
    }

    public void run(String inputFilename) throws IOException {
        try {
            rot13Translator.translate(inputFilename);
        } catch (Exception e) {
            errorLogger.log(e);
        }
        streamToFlushWhenAppFinishes.flush();
    }
}
