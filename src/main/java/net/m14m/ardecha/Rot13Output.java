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
        if (inFirstHalfOfAlphabet(character)) return character + 13;
        if (inSecondHalfOfAlphabet(character)) return character - 13;
        return character;
    }

    private boolean inFirstHalfOfAlphabet(int character) {
        return (character >= 'a' && character <= 'm') || (character >= 'A' && character <= 'M');
    }

    private boolean inSecondHalfOfAlphabet(int character) {
        return (character >= 'n' && character <= 'z') || (character >= 'N' && character <= 'Z');
    }
}
