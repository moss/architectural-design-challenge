package net.m14m.ardecha.testing_support;

import org.junit.*;

public class TestableOutputTest {
    private TestableOutput output = new TestableOutput();

    @Test public void shouldLetYouTestWhatOutputHasBeenWritten() {
        output.write('a');
        output.write('b');
        output.write('c');

        output.shouldEqual("abc");
    }
}
