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
            int length = (int) file.length();
            FileInputStream inputStream = new FileInputStream(file);
            return new StreamBackedTextFile(inputStream, length);
        } catch (IOException e) {
            throw new InputException();
        }
    }

    private static class StreamBackedTextFile implements TextFile {
        private final FileInputStream inputStream;
        private final int length;

        public StreamBackedTextFile(FileInputStream inputStream, int length) {
            this.inputStream = inputStream;
            this.length = length;
        }

        public void writeTo(Output output) {
            try {
                for (int i = 0; i < length; i++) {
                    int character = inputStream.read();
                    output.write(character);
                }
            } catch (IOException e) {
                throw new InputException();
            }
        }
    }
}
