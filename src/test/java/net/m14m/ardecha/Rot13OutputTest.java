package net.m14m.ardecha;

import net.m14m.ardecha.testing_support.TestableOutput;
import org.junit.*;

public class Rot13OutputTest {
    private TestableOutput wrappedOutput = new TestableOutput();
    private Rot13Output output = new Rot13Output(wrappedOutput);

    // abcdefghijklm
    // nopqrstuvwxyz

    @Test public void lowercaseLettersInTheFirstHalfOfTheAlphabetShouldMoveToTheSecondHalf() {
        output.write('a');
        output.write('m');

        wrappedOutput.shouldEqual("nz");
    }
}
