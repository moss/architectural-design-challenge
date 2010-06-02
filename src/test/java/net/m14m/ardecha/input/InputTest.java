package net.m14m.ardecha.input;

import org.junit.*;

import java.io.StringReader;
import java.util.Iterator;

import static net.m14m.ardecha.input.InputAssertions.assertHasCharacters;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

    @Test public void shouldCloseTheReaderWhenItIsDone() throws Exception {
        StringReader reader = spy(new StringReader("foo"));
        input = Input.fromReader(reader);
        Iterator<?> inputIterator = input.iterator();
        inputIterator.next();
        inputIterator.next();
        inputIterator.next();
        verify(reader).close();
    }
}
