package net.m14m.ardecha.characters;

public class TranslatableCharacter {
    private final int character;

    public TranslatableCharacter(int character) {
        this.character = character;
    }

    public TranslatableCharacter translate() {
        return new TranslatableCharacter(character + 13);
    }

    public int toInteger() {
        return character;
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
