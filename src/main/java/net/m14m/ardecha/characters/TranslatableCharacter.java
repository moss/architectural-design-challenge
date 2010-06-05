package net.m14m.ardecha.characters;

public class TranslatableCharacter {
    private final int character;

    public TranslatableCharacter(int character) {
        this.character = character;
    }

    public TranslatableCharacter translate() {
        if (isPunctuation()) return this;
        int translated = character + 13;
        if (inSecondHalfOfAlphabet()) translated -= 26;
        return new TranslatableCharacter(translated);
    }

    public int toInteger() {
        return character;
    }

    private boolean isPunctuation() {
        return !isLetter();
    }

    private boolean isLetter() {
        return inRange('a', 'z') || inRange('A', 'Z');
    }

    private boolean inSecondHalfOfAlphabet() {
        return inRange('n', 'z') || inRange('N', 'Z');
    }

    private boolean inRange(char from, char to) {
        return (character >= from && character <= to);
    }

    @Override public String toString() {
        return new String(new int[] { character }, 0, 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return character == ((TranslatableCharacter) o).character;
    }

    @Override
    public int hashCode() {
        return character;
    }
}
