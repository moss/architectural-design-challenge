package net.m14m.ardecha.application;

import net.m14m.ardecha.input.Input;
import net.m14m.ardecha.output.Output;

public interface Translator {
    void translate(Input input, Output output);
}
