package net.m14m.ardecha;

import java.io.File;

public class Rot13Application {
    private final FileRepository fileRepository;
    private final Output output;

    public static void main(String[] args) {
        File ioDirectory = new File(System.getProperty("io-directory"));
        Rot13Application application = new Rot13Application(
                new DirectoryBackedFileRepository(ioDirectory),
                new Rot13Output(
                        new MultiOutput(
                                new SystemOutput(),
                                new FileOutput(ioDirectory, args[1]))));
        application.rot13(args[0]);
    }

    public Rot13Application(FileRepository fileRepository, Output output) {
        this.fileRepository = fileRepository;
        this.output = output;
    }

    public void rot13(String inputFilename) {
        TextFile textFile = fileRepository.loadFile(inputFilename);
        textFile.writeTo(output);
    }
}
