package net.m14m.ardecha;

public class Rot13Application {
    private final FileRepository fileRepository;
    private final OutputRepository outputRepository;

    public static void main(String[] args) {
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
