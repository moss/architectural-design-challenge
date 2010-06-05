package net.m14m.ardecha.output;

import net.m14m.ardecha.characters.TranslatableCharacter;

import java.io.PrintStream;

public class SystemOutput implements Output {
    private PrintStream printStream;

    public SystemOutput(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void writeChar(TranslatableCharacter translatableCharacter) {
        printStream.write(translatableCharacter.toInteger());
        printStream.flush();
    }
}
