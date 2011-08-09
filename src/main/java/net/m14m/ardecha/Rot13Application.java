package net.m14m.ardecha;

import java.io.File;

public class Rot13Application {
    private final FileRepository fileRepository;
    private final OutputRepository outputRepository;

    public static void main(String[] args) {
        File ioDirectory = new File(System.getProperty("io-directory"));
        DirectoryBackedFileRepository fileRepository = new DirectoryBackedFileRepository(ioDirectory);
        Rot13Application application = new Rot13Application(fileRepository, null);
        application.run(args[0], args[1]);
    }

    public Rot13Application(FileRepository fileRepository, OutputRepository outputRepository) {
        this.fileRepository = fileRepository;
        this.outputRepository = outputRepository;
    }

    public void run(String inputFilename, String outputFilename) {
        TextFile textFile = fileRepository.loadFile(inputFilename);
        Output output = outputRepository.createOutput(outputFilename);
        textFile.writeTo(output);
    }
}
