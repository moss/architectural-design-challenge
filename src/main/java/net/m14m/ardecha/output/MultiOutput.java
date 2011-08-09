package net.m14m.ardecha.output;

import net.m14m.ardecha.Output;

public class MultiOutput implements Output {
    private final Output[] outputs;

    public MultiOutput(Output... outputs) {
        this.outputs = outputs;
    }

    public void write(int character) {
        for (Output output : outputs) output.write(character);
    }
}
