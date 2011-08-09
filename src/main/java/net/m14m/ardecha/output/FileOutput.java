package net.m14m.ardecha.output;

import net.m14m.ardecha.Output;

import java.io.*;

public class FileOutput implements Output {
    private final Writer writer;

    public static FileOutput open(File directory, String filename) throws IOException {
        File file = new File(directory, filename);
        FileWriter writer = new FileWriter(file);
        return new FileOutput(writer);
    }

    private FileOutput(Writer writer) {
        this.writer = writer;
    }

    public void write(int character) {
        try {
            writer.write(character);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
