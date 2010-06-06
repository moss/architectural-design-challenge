package net.m14m.ardecha.application;

import net.m14m.ardecha.input.FilesystemBackedInputRepository;

import java.io.*;

public class Rot13Application {
    private final Rot13Translator rot13Translator;
    private final ErrorLogger errorLogger;
    private final Flushable streamToFlushWhenAppFinishes;

    public static void main(String... args) throws IOException {
        Rot13Application applicaton = new Rot13ApplicationFactory()
                .withInputRepository(FilesystemBackedInputRepository.create())
                .withOutputStream(System.out)
                .create();
        applicaton.run(args[0], args[1]);
    }

    public Rot13Application(Rot13Translator translator, ErrorLogger errorLogger,
                            Flushable streamToFlushWhenAppFinishes) {
        this.rot13Translator = translator;
        this.errorLogger = errorLogger;
        this.streamToFlushWhenAppFinishes = streamToFlushWhenAppFinishes;
    }

    public void run(String inputFilename, String outputFile) throws IOException {
        try {
            rot13Translator.translate(inputFilename);
        } catch (Exception e) {
            errorLogger.log(e);
        }
        streamToFlushWhenAppFinishes.flush();
    }
}
