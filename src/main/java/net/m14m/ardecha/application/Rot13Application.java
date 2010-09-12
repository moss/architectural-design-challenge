package net.m14m.ardecha.application;

import java.io.*;

public class Rot13Application {
    private final TranslationIoCoordinator ioCoordinator;
    private final ErrorLogger errorLogger;
    private final Flushable streamToFlushWhenAppFinishes;

    public Rot13Application(TranslationIoCoordinator ioCoordinator, ErrorLogger errorLogger,
                            Flushable streamToFlushWhenAppFinishes) {
        this.ioCoordinator = ioCoordinator;
        this.errorLogger = errorLogger;
        this.streamToFlushWhenAppFinishes = streamToFlushWhenAppFinishes;
    }

    public void run(String inputFilename, String outputFile) throws IOException {
        try {
            ioCoordinator.translate(inputFilename, outputFile);
        } catch (Exception e) {
            errorLogger.log(e);
        }
        streamToFlushWhenAppFinishes.flush();
    }
}
