package net.m14m.ardecha.application;

import net.m14m.ardecha.input.*;
import net.m14m.ardecha.output.*;

import java.io.*;

public class Rot13ApplicationRunner {
    private InputRepository inputRepository;
    private OutputFileRepository outputRepository;
    private PrintStream standardOutput;

    public static void main(String... args) throws IOException {
        String repositoryPath = System.getProperty("repositoryPath");
        new Rot13ApplicationRunner()
                .withInputRepository(new FilesystemBackedInputRepository(repositoryPath))
                .withOutputRepository(new FilesystemBackedOutputRepository(repositoryPath))
                .withSystemOutputStream(System.out)
                .run(args);
    }

    public Rot13ApplicationRunner withInputRepository(InputRepository repository) {
        this.inputRepository = repository;
        return this;
    }

    public Rot13ApplicationRunner withOutputRepository(OutputFileRepository outputRepository) {
        this.outputRepository = outputRepository;
        return this;
    }

    public Rot13ApplicationRunner withSystemOutputStream(PrintStream outputStream) {
        this.standardOutput = outputStream;
        return this;
    }

    public void run(String... args) throws IOException {
        PrintWriter writerWrappingSystemOut = new PrintWriter(standardOutput);
        ErrorLogger errorLogger = new ErrorLogger(writerWrappingSystemOut);
        new Rot13Application(createIoCoordinator(), errorLogger, writerWrappingSystemOut)
                .run(args[0], args[1]);
    }

    private TranslationIoCoordinator createIoCoordinator() {
        PrintStreamOutput output = new PrintStreamOutput(standardOutput);
        OutputFileRepository multiOutputRepository =
                new ConsoleAndFileOutputRepository(outputRepository, output);
        Rot13Translator translator = new Rot13Translator();
        return new TranslationIoCoordinator(inputRepository, multiOutputRepository, translator);
    }
}
