package net.m14m.ardecha.input;

import java.io.*;

public class StringableFile {
    private File file;

    public StringableFile(File file) {
        this.file = file;
    }

    public String read() throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
        return copyReaderToString(fileReader);
    }

    private String copyReaderToString(FileReader fileReader) {
        try {
            StringBuilder builder = new StringBuilder();
            while (fileReader.ready()) builder.appendCodePoint(fileReader.read());
            fileReader.close();
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
