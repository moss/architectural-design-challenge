package net.m14m.ardecha;

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
            final int[] fileContents = new int[length];
            FileInputStream inputStream = new FileInputStream(file);
            for (int i = 0; i < length; i++) {
                fileContents[i] = inputStream.read();
            }
            return new TextFile() {
                public void writeTo(Output output) {
                    for (int character : fileContents) {
                        output.write(character);
                    }
                }
            };
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
