package net.m14m.ardecha.input;

import java.io.*;

public class FilesystemBackedInputRepositoryTest extends InputRepositoryContract {
    @Override protected void writeFile(String filename, String contents) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(contents);
        writer.close();
    }

    @Override protected FilesystemBackedInputRepository getRepository() {
        return new FilesystemBackedInputRepository();
    }

    @Override protected void deleteFile(String filename) {
        //noinspection ResultOfMethodCallIgnored
        new File(filename).delete();
    }
}
