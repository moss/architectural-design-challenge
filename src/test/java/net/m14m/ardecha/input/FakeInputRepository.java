package net.m14m.ardecha.input;

import java.io.*;
import java.util.*;

public class FakeInputRepository implements InputRepository {
    private Map<String,Input> files = new HashMap<String, Input>();

    public void createFile(String filename, String content) {
        files.put(filename, Input.fromReader(new StringReader(content)));
    }

    public Input load(String filename) throws FileNotFoundException {
        if (!files.containsKey(filename)) throw new FileNotFoundException(filename);
        return files.get(filename);
    }
}
