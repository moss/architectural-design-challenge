package net.m14m.ardecha.output;

import java.io.*;

public class FilesystemBackedOutputRepository implements OutputFileRepository {
    private final String repositoryPath;

    public FilesystemBackedOutputRepository(String repositoryPath) {
        this.repositoryPath = repositoryPath;
    }

    public Output create(String filename) throws IOException {
        File file = new File(repositoryPath, filename);
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        return new PrintStreamOutput(new PrintStream(outputStream));
    }
}
