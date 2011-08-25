package net.m14m.ardecha.output;

import net.m14m.ardecha.Output;

public class SystemOutput implements Output {
    public void write(int character) {
        System.out.print((char) character);
    }
}
