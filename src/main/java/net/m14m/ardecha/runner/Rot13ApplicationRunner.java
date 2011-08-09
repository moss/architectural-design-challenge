package net.m14m.ardecha.runner;

import net.m14m.ardecha.application.Rot13Application;
import net.m14m.ardecha.input.DirectoryBackedFileRepository;
import net.m14m.ardecha.output.*;

import java.io.*;

public class Rot13ApplicationRunner {
    public static void main(String[] args) throws IOException {
        File ioDirectory = new File(System.getProperty("io-directory"));
        Rot13Application application = new Rot13Application(
                new DirectoryBackedFileRepository(ioDirectory),
                new Rot13Output(
                        new MultiOutput(
                                new SystemOutput(),
                                FileOutput.open(ioDirectory, args[1]))));
        application.rot13(args[0]);
    }
}
