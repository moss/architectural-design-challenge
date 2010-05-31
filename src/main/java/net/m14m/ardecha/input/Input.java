package net.m14m.ardecha.input;

import java.io.*;

public class Input {
    private final Reader reader;

    public Input(Reader reader) {
        this.reader = reader;
    }

    public int readChar() {
        try {
            return reader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
