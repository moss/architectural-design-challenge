package net.m14m.ardecha.input;

import java.io.StringReader;
import java.util.*;

public class FakeInputRepository implements InputRepository {
    private Map<String,Input> files = new HashMap<String, Input>();

    public void createFile(String filename, String content) {
        files.put(filename, new Input(new StringReader(content)));
    }

    public Input load(String filename) {
        return files.get(filename);
    }
}
