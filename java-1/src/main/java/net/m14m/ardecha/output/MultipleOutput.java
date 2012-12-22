package net.m14m.ardecha.output;

import net.m14m.ardecha.characters.TranslatableCharacter;

public class MultipleOutput implements Output {
    private final Output[] outputs;

    public MultipleOutput(Output... outputs) {
        this.outputs = outputs;
    }

    public void writeChar(TranslatableCharacter character) {
        for (Output output : outputs) {
            output.writeChar(character);
        }
    }
}
