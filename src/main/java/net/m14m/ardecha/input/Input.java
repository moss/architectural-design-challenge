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
        return new ReaderIterator();
    }

    private class ReaderIterator implements Iterator<Integer> {
        private int nextCharacter;

        public ReaderIterator() {
            advance();
        }

        public boolean hasNext() {
            return nextCharacter != -1;
        }

        public Integer next() {
            int result = nextCharacter;
            advance();
            return result;
        }

        private void advance() {
            nextCharacter = readChar();
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't modify input");
        }
    }
}
