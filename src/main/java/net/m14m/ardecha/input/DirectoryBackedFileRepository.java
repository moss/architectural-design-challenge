package net.m14m.ardecha.input;

import net.m14m.ardecha.*;

import java.io.*;

public class DirectoryBackedFileRepository implements FileRepository {
    private final File directory;

    public DirectoryBackedFileRepository(File directory) {
        this.directory = directory;
    }

    public TextFile loadFile(String filename) {
        final int[] fileContents = readContents(new File(directory, filename));
        return new TextFile() {
            public void writeTo(Output output) {
                for (int character : fileContents) {
                    output.write(character);
                }
            }
        };
    }

    private int[] readContents(File file) {
        try {
            int length = (int) file.length();
            int[] fileContents = new int[length];
            FileInputStream inputStream = new FileInputStream(file);
            for (int i = 0; i < length; i++) {
                fileContents[i] = inputStream.read();
            }
            return fileContents;
        } catch (IOException e) {
            throw new InputException();
        }
    }
}
