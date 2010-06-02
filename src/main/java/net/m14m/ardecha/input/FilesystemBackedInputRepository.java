package net.m14m.ardecha.input;

import java.io.*;

public class FilesystemBackedInputRepository implements InputRepository {
    public Input load(String filename) throws FileNotFoundException {
        return Input.fromReader(new FileReader(filename));
    }
}
