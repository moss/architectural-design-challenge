package net.m14m.ardecha.input;

import net.m14m.ardecha.characters.TranslatableCharacter;

import java.io.*;
import java.util.Iterator;

public class Input implements Iterable<TranslatableCharacter> {
    private final Reader reader;

    public Input(Reader reader) {
        this.reader = reader;
    }

    public Iterator<TranslatableCharacter> iterator() {
        return new ReaderIterator();
    }

    private class ReaderIterator implements Iterator<TranslatableCharacter> {
        private int nextCharacter;

        public ReaderIterator() {
            advance();
        }

        public boolean hasNext() {
            return nextCharacter != -1;
        }

        public TranslatableCharacter next() {
            int result = nextCharacter;
            if (hasNext()) advance();
            return new TranslatableCharacter(result);
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
