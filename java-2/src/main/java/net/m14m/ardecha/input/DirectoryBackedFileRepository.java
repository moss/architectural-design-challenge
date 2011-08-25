package net.m14m.ardecha.input;

import net.m14m.ardecha.*;

import java.io.*;

public class DirectoryBackedFileRepository implements FileRepository {
    private final File directory;

    public DirectoryBackedFileRepository(File directory) {
        this.directory = directory;
    }

    public TextFile loadFile(String filename) {
        try {
            File file = new File(directory, filename);
            FileInputStream inputStream = new FileInputStream(file);
            return new StreamBackedTextFile(inputStream);
        } catch (IOException e) {
            throw new InputException();
        }
    }

    private static class StreamBackedTextFile implements TextFile {
        private final FileInputStream inputStream;

        public StreamBackedTextFile(FileInputStream inputStream) {
            this.inputStream = inputStream;
        }

        public void writeTo(Output output) {
            try {
                int character;
                while ((character = inputStream.read()) != -1) {
                    output.write(character);
                }
            } catch (IOException e) {
                throw new InputException();
            }
        }
    }
}
