package net.m14m.ardecha.input;

import java.io.*;

public class FilesystemBackedInputRepository implements InputRepository {
    private final String repositoryPath;

    public static InputRepository create() {
        return new FilesystemBackedInputRepository(System.getProperty("repositoryPath"));
    }

    public FilesystemBackedInputRepository(String repositoryPath) {
        this.repositoryPath = repositoryPath;
    }

    public Input load(String filename) throws FileNotFoundException {
        String contents = new StringableFile(new File(repositoryPath, filename)).read();
        return new Input(contents);
    }
}
