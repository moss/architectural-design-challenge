package net.m14m.ardecha.input;

import java.io.*;
import java.util.Iterator;

public class Input implements Iterable<Integer> {
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

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return false;
            }

            public Integer next() {
                return readChar();
            }

            public void remove() {
                throw new UnsupportedOperationException("Can't modify input");
            }
        };
    }
}
