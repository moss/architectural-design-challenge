package net.m14m.ardecha;

public class SystemOutput implements Output {
    public void write(char character) {
        System.out.print(character);
    }
}
