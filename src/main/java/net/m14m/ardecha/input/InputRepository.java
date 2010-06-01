package net.m14m.ardecha.input;

import java.io.FileNotFoundException;

public interface InputRepository {
    Input load(String filename) throws FileNotFoundException;
}
