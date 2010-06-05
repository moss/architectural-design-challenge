package net.m14m.ardecha.application;

import java.io.*;

public class ErrorLogger {
    private final PrintWriter ouputWriter;

    public ErrorLogger(PrintWriter ouputWriter) {
        this.ouputWriter = ouputWriter;
    }

    public void log(Exception e) {
        // if this gets bigger consider making some sort of collection of ErrorFormatters
        if (e instanceof FileNotFoundException) {
            printFileNotFoundMessage(e);
        } else {
            printGenericMessage(e);
        }
        ouputWriter.flush();
    }

    private void printGenericMessage(Exception e) {
        ouputWriter.println("An error occurred.");
        e.printStackTrace(ouputWriter);
    }

    private void printFileNotFoundMessage(Exception e) {
        ouputWriter.println("File not found: " + e.getMessage());
    }
}
