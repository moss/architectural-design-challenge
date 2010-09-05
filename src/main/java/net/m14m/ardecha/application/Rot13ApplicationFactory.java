package net.m14m.ardecha.application;

import net.m14m.ardecha.input.InputRepository;
import net.m14m.ardecha.output.*;

import java.io.*;

public class Rot13ApplicationFactory {
    private InputRepository inputRepository;
    private OutputFileRepository outputRepository;
    private PrintStream outputStream;

    public Rot13ApplicationFactory withInputRepository(InputRepository repository) {
        this.inputRepository = repository;
        return this;
    }

    public Rot13ApplicationFactory withOutputRepository(OutputFileRepository outputRepository) {
        this.outputRepository = outputRepository;
        return this;
    }

    public Rot13ApplicationFactory withOutputStream(PrintStream outputStream) {
        this.outputStream = outputStream;
        return this;
    }

    public Rot13Application create() {
        PrintWriter writerWrappingSystemOut = new PrintWriter(outputStream);
        PrintStreamOutput output = new PrintStreamOutput(outputStream);
        ErrorLogger errorLogger = new ErrorLogger(writerWrappingSystemOut);
        TranslationIoCoordinator ioCoordinator = new TranslationIoCoordinator(inputRepository,
                output, new Rot13Translator());
        return new Rot13Application(ioCoordinator, errorLogger, writerWrappingSystemOut);
    }
}
