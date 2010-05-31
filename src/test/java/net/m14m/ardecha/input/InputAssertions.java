package net.m14m.ardecha.input;

import java.util.Iterator;

import static org.junit.Assert.*;

public class InputAssertions {
    static void assertHasCharacters(Input input, char... expectedCharacters) {
        Iterator<Integer> inputIterator = input.iterator();
        for (char c : expectedCharacters) {
            assertEquals(new Integer(c), inputIterator.next());
        }
    }

    private InputAssertions() {}
}
