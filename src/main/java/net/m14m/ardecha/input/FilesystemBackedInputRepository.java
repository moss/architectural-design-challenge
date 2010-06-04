package net.m14m.ardecha.input;

import java.io.*;

public class FilesystemBackedInputRepository implements InputRepository {
    private final String repositoryPath;

    public FilesystemBackedInputRepository(String repositoryPath) {
        this.repositoryPath = repositoryPath;
    }

    public Input load(String filename) throws FileNotFoundException {
        return readInputFile(new FileReader(new File(repositoryPath, filename)));
    }

    private Input readInputFile(Reader reader) {
        try {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) builder.appendCodePoint(reader.read());
            reader.close();
            return new Input(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
