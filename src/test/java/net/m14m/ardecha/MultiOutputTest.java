package net.m14m.ardecha;

import net.m14m.ardecha.testing_support.TestableOutput;
import org.junit.*;

public class MultiOutputTest {
    private TestableOutput wrappedOutput1 = new TestableOutput();
    private TestableOutput wrappedOutput2 = new TestableOutput();
    private MultiOutput multiOutput = new MultiOutput(wrappedOutput1, wrappedOutput2);

    @Test public void shouldRepeatOutputToAllItsWrappedOutputs() {
        multiOutput.write('a');
        multiOutput.write('b');
        multiOutput.write('c');

        wrappedOutput1.shouldEqual("abc");
        wrappedOutput2.shouldEqual("abc");
    }
}
