package net.m14m.ardecha.input;

import org.junit.*;

import java.io.StringReader;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class InputTest {
    private StringReader reader = new StringReader("foo");
    private Iterator<Integer> inputIterator;
    private Input input;

    @Before public void createInputAndIterator() throws Exception {
        input = new Input(reader);
        inputIterator = input.iterator();
    }

    @Test public void shouldIterateOverCharacters() {
        assertEquals(new Integer('f'), inputIterator.next());
        assertEquals(new Integer('o'), inputIterator.next());
        assertEquals(new Integer('o'), inputIterator.next());
    }

    @Test public void shouldIndicateWhetherMoreCharactersRemain() {
        assertTrue("before first char", inputIterator.hasNext());
        inputIterator.next();
        assertTrue("after first char", inputIterator.hasNext());
        inputIterator.next();
        assertTrue("after second char", inputIterator.hasNext());
        inputIterator.next();
        assertFalse("after third char", inputIterator.hasNext());
    }

    @Test public void BEWARE_newIteratorsWillNotStartOverFromTheBeginning_maybeThisShouldBeFixed() {
        assertEquals(new Integer('f'), inputIterator.next());
        Iterator<Integer> aNewIterator = input.iterator();
        assertEquals("even a new iterator returns the next character",
                new Integer('o'), aNewIterator.next());
    }

    @Test public void shouldCloseTheReaderWhenItIsDone() throws Exception {
        reader = spy(reader);
        createInputAndIterator();
        inputIterator.next();
        inputIterator.next();
        inputIterator.next();
        verify(reader).close();
    }
}
