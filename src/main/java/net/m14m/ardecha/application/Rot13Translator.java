package net.m14m.ardecha.application;

import net.m14m.ardecha.characters.TranslatableCharacter;
import net.m14m.ardecha.input.Input;
import net.m14m.ardecha.output.Output;

public class Rot13Translator {
    public Rot13Translator() {
    }

    public void translate(Input input, Output output) {
        for (TranslatableCharacter character : input) {
            output.writeChar(character.translate());
        }
    }
}