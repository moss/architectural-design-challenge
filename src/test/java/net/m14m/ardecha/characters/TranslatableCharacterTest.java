package net.m14m.ardecha.characters;

import org.junit.*;

import static junit.framework.Assert.*;

public class TranslatableCharacterTest {
    @Test public void shouldAdvanceLettersForward13PositionsInTheAlphabet() {
        assertTranslation('a', 'n');
        assertTranslation('m', 'z');
    }

    @Test public void shouldWrapAroundWhenItGetsToTheEndOfTheAlphabet() {
        assertTranslation('n', 'a');
        assertTranslation('z', 'm');
    }

    @Test public void shouldLeavePunctuationUnchanged() {
        assertTranslation('.', '.');
        assertTranslation('z' + 1, 'z' + 1);
        assertTranslation('a' - 1, 'a' - 1);
        assertTranslation('Z' + 1, 'Z' + 1);
        assertTranslation('A' - 1, 'A' - 1);
    }

    private void assertTranslation(int fromCharacter, int expectedResult) {
        assertEquals(new TranslatableCharacter(expectedResult),
                new TranslatableCharacter(fromCharacter).translate());
    }

    @Test public void shouldRecognizeEquality() {
        TranslatableCharacter character = new TranslatableCharacter(45);
        TranslatableCharacter equal = new TranslatableCharacter(45);
        TranslatableCharacter unequal = new TranslatableCharacter(55);
        assertTrue("equals are equal", character.equals(equal));
        assertFalse("unequals not equal", character.equals(unequal));
        assertTrue("anything is equal to itself", character.equals(character));
    }
}
