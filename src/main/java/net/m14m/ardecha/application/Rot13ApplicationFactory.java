package net.m14m.ardecha.application;

import net.m14m.ardecha.input.*;
import net.m14m.ardecha.output.PrintStreamOutput;

import java.io.*;

class Rot13ApplicationFactory {
    public Rot13Application create() {
        InputRepository repository = FilesystemBackedInputRepository.create();
        PrintStream systemOut = System.out;
        PrintWriter writerWrappingSystemOut = new PrintWriter(systemOut);
        PrintStreamOutput output = new PrintStreamOutput(systemOut);
        ErrorLogger errorLogger = new ErrorLogger(writerWrappingSystemOut);
        Rot13Translator translator = new Rot13Translator(repository, output);
        return new Rot13Application(translator, errorLogger, writerWrappingSystemOut);
    }
}
