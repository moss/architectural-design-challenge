package net.m14m.ardecha.application;

import net.m14m.ardecha.input.FilesystemBackedInputRepository;

import java.io.*;

public class Rot13Application {
    private final TranslationIoCoordinator ioCoordinator;
    private final ErrorLogger errorLogger;
    private final Flushable streamToFlushWhenAppFinishes;

    public static void main(String... args) throws IOException {
        Rot13Application applicaton = new Rot13ApplicationFactory()
                .withInputRepository(FilesystemBackedInputRepository.create())
                .withOutputStream(System.out)
                .create();
        applicaton.run(args[0], args[1]);
    }

    public Rot13Application(TranslationIoCoordinator ioCoordinator, ErrorLogger errorLogger,
                            Flushable streamToFlushWhenAppFinishes) {
        this.ioCoordinator = ioCoordinator;
        this.errorLogger = errorLogger;
        this.streamToFlushWhenAppFinishes = streamToFlushWhenAppFinishes;
    }

    public void run(String inputFilename, String outputFile) throws IOException {
        try {
            ioCoordinator.translate(inputFilename);
        } catch (Exception e) {
            errorLogger.log(e);
        }
        streamToFlushWhenAppFinishes.flush();
    }
}
