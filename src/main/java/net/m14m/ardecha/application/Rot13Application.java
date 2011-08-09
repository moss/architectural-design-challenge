package net.m14m.ardecha.application;

import net.m14m.ardecha.*;

public class Rot13Application {
    private final FileRepository fileRepository;
    private final Output output;

    public Rot13Application(FileRepository fileRepository, Output output) {
        this.fileRepository = fileRepository;
        this.output = output;
    }

    public void rot13(String inputFilename) {
        TextFile textFile = fileRepository.loadFile(inputFilename);
        textFile.writeTo(output);
    }
}
