package net.m14m.ardecha;

public class Rot13Output implements Output {
    private final Output output;

    public Rot13Output(Output output) {
        this.output = output;
    }

    public void write(int character) {
        output.write(rot13(character));
    }

    private int rot13(int character) {
        if (character >= 'a' && character <= 'm') return character + 13;
        if (character >= 'n' && character <= 'z') return character - 13;
        return character;
    }
}
