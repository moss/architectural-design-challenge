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

    private void assertTranslation(char fromCharacter, char expectedResult) {
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
