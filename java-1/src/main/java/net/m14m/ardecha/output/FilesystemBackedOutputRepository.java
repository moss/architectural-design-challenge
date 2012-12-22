package net.m14m.ardecha.output;

import java.io.*;

public class FilesystemBackedOutputRepository implements OutputFileRepository {
    private final String repositoryPath;

    public FilesystemBackedOutputRepository(String repositoryPath) {
        this.repositoryPath = repositoryPath;
    }

    public Output create(String filename) throws IOException {
        File file = new File(repositoryPath, filename);
        boolean created = file.createNewFile();
        if (!created) throw new IOException("File " + filename + " already exists.");
        FileOutputStream outputStream = new FileOutputStream(file);
        return new PrintStreamOutput(new PrintStream(outputStream));
    }
}
