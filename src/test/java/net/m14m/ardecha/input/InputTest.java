package net.m14m.ardecha.input;

import org.junit.*;

import java.util.Iterator;

import static net.m14m.ardecha.input.InputAssertions.assertHasCharacters;
import static org.junit.Assert.*;

public class InputTest {
    private Input input;

    @Before public void createInput() throws Exception {
        input = new Input("fob");
    }

    @Test public void shouldIterateOverCharacters() {
        assertHasCharacters(input, 'f', 'o', 'b');
    }

    @Test public void shouldIndicateWhetherMoreCharactersRemain() {
        Iterator<?> inputIterator = input.iterator();
        assertTrue("before first char", inputIterator.hasNext());
        inputIterator.next();
        assertTrue("after first char", inputIterator.hasNext());
        inputIterator.next();
        assertTrue("after second char", inputIterator.hasNext());
        inputIterator.next();
        assertFalse("after third char", inputIterator.hasNext());
    }
}
