package net.m14m.ardecha.input;

import org.junit.*;

import java.io.StringReader;
import java.util.Iterator;

import static net.m14m.ardecha.input.InputAssertions.assertHasCharacters;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class InputTest {
    private StringReader reader = new StringReader("fob");
    private Input input;

    @Before public void createInput() throws Exception {
        input = new Input(reader);
    }

    @Test public void shouldIterateOverCharacters() {
        assertHasCharacters(input, 'f', 'o', 'b');
    }

    @Test public void shouldIndicateWhetherMoreCharactersRemain() {
        Iterator<Integer> inputIterator = input.iterator();
        assertTrue("before first char", inputIterator.hasNext());
        inputIterator.next();
        assertTrue("after first char", inputIterator.hasNext());
        inputIterator.next();
        assertTrue("after second char", inputIterator.hasNext());
        inputIterator.next();
        assertFalse("after third char", inputIterator.hasNext());
    }

    @Test public void BEWARE_allIteratorsShareTheSameReader_whichCausesUnexpectedBehavior_maybeThisShouldBeFixed() {
        Iterator<Integer> oneIterator = input.iterator();
        assertEquals(new Integer('f'), oneIterator.next());
        Iterator<Integer> aNewIterator = input.iterator();
        assertEquals( "creating the new iterator advanced the underlying reader, and calling next advances it again",
                new Integer('b'), aNewIterator.next());
    }

    @Test public void shouldCloseTheReaderWhenItIsDone() throws Exception {
        reader = spy(reader);
        createInput();
        Iterator inputIterator = input.iterator();
        inputIterator.next();
        inputIterator.next();
        inputIterator.next();
        verify(reader).close();
    }
}
