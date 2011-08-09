package net.m14m.ardecha;

public class SystemOutput implements Output {
    public void write(int character) {
        System.out.print((char) character);
    }
}
