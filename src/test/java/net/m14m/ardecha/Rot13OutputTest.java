package net.m14m.ardecha;

import net.m14m.ardecha.testing_support.TestableOutput;
import org.junit.*;

public class Rot13OutputTest {
    private TestableOutput wrappedOutput = new TestableOutput();
    private Rot13Output output = new Rot13Output(wrappedOutput);

    // abcdefghijklm
    // nopqrstuvwxyz

    @Test public void lettersInTheFirstHalfOfTheAlphabetShouldMoveToTheSecondHalf() {
        output.write('a');
        output.write('m');

        wrappedOutput.shouldEqual("nz");
    }

    @Test public void lettersInTheSecondHalfOfTheAlphabetShouldMoveToTheFirstHalf() {
        output.write('n');
        output.write('z');

        wrappedOutput.shouldEqual("am");
    }

    @Test public void shouldTranslateUppercaseLetters() {
        output.write('A');
        output.write('M');
        output.write('N');
        output.write('Z');

        wrappedOutput.shouldEqual("NZAM");
    }

    @Test public void punctuationShouldBeUnaffected() {
        output.write('`'); // 'a' - 1
        output.write('{'); // 'z' + 1
        output.write('@'); // 'A' - 1
        output.write('['); // 'Z' + 1
        output.write('.');
        output.write(' ');
        output.write('1');

        wrappedOutput.shouldEqual("`{@[. 1");
    }
}
