package net.m14m.ardecha.application;

import java.io.PrintWriter;

public class ErrorLogger {
    private final PrintWriter ouputWriter;

    public ErrorLogger(PrintWriter ouputWriter) {
        this.ouputWriter = ouputWriter;
    }

    public void log(Exception e) {
        ouputWriter.println("An error occurred.");
        e.printStackTrace(ouputWriter);
    }
}
