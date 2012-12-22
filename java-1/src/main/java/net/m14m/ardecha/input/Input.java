package net.m14m.ardecha.input;

import net.m14m.ardecha.characters.TranslatableCharacter;

import java.util.Iterator;

public class Input implements Iterable<TranslatableCharacter> {
    private final String contents;

    public Input(String contents) {
        this.contents = contents;
    }

    public Iterator<TranslatableCharacter> iterator() {
        return new ReaderIterator();
    }

    private class ReaderIterator implements Iterator<TranslatableCharacter> {
        private int position = 0;

        public boolean hasNext() {
            return position < contents.length();
        }

        public TranslatableCharacter next() {
            int nextChar = contents.codePointAt(position);
            position++;
            return new TranslatableCharacter(nextChar);
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't modify input");
        }
    }
}
