package net.m14m.ardecha.output;

import java.io.IOException;
import java.util.*;

public class FakeOutputFileRepository implements OutputFileRepository {
    private Map<String, FakeOutput> files = new HashMap<String, FakeOutput>();

    public Output create(String filename) throws IOException {
        FakeOutput output = new FakeOutput();
        files.put(filename, output);
        return output;
    }

    public void shouldContainFile(String filename, String expectedContent) {
        files.get(filename).shouldHavePrinted(expectedContent);
    }
}
