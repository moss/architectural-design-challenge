package net.m14m.ardecha.input;

import java.io.*;

public class FilesystemBackedInputRepository implements InputRepository {
    public Input load(String filename) {
        try {
            return new Input(new FileReader(filename));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
