package net.m14m.ardecha.input;

import java.io.*;
import java.util.Iterator;

public class Input implements Iterable<Integer> {
    private final Reader reader;

    public Input(Reader reader) {
        this.reader = reader;
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
            if (hasNext()) advance();
            return result;
        }

        private void advance() {
            try {
                nextCharacter = reader.read();
                if (!hasNext()) reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't modify input");
        }
    }
}
