package net.m14m.ardecha.output;

import net.m14m.ardecha.characters.TranslatableCharacter;

public class SystemOutput implements Output {
    public void writeChar(TranslatableCharacter translatableCharacter) {
        System.out.write(translatableCharacter.toInteger());
        System.out.flush();
    }
}
