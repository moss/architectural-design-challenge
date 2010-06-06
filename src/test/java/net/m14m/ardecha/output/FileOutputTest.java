package net.m14m.ardecha.output;

import java.io.File;

public class FileOutputTest extends OutputContract {
    private static final File FILE = new File("output-file-for-FileOutputTest");

    @Override protected Output getOutput() {
        return new FileOutput(FILE);
    }

    @Override protected void shouldHavePrinted(String expectedOutput) throws Exception {
        
    }
}
