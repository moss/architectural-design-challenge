package net.m14m.ardecha.input;

import net.m14m.ardecha.characters.TranslatableCharacter;

import java.util.Iterator;

import static org.junit.Assert.*;

public class InputAssertions {
    static void assertHasCharacters(Input input, char... expectedCharacters) {
        Iterator<TranslatableCharacter> inputIterator = input.iterator();
        for (char c : expectedCharacters) {
            assertEquals(new TranslatableCharacter(c), inputIterator.next());
        }
    }

    private InputAssertions() {}
}
