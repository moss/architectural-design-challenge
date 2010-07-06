package net.m14m.ardecha.output;

import java.io.IOException;

public interface OutputFileRepository {
    Output create(String filename) throws IOException;
}
