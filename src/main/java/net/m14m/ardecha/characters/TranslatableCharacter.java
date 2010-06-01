package net.m14m.ardecha.characters;

public class TranslatableCharacter {
    private final int character;

    public TranslatableCharacter(int character) {
        this.character = character;
    }

    public int toInteger() {
        return character;
    }
}
