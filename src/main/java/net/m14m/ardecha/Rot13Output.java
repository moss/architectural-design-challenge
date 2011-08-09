package net.m14m.ardecha;

public class Rot13Output implements Output {
    private final Output output;

    public Rot13Output(Output output) {
        this.output = output;
    }

    public void write(int character) {
        output.write(character + 13);
    }
}
