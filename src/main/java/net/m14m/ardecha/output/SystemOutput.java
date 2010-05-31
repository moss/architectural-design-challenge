package net.m14m.ardecha.output;

public class SystemOutput implements Output {
    public void writeChar(int character) {
        System.out.write(character);
    }
}
