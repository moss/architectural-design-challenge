package net.m14m.ardecha.output;

import net.m14m.ardecha.characters.TranslatableCharacter;
import org.junit.*;

public class MultipleOutputTest {
    private FakeOutput output1 = new FakeOutput();
    private FakeOutput output2 = new FakeOutput();
    private MultipleOutput multipleOutput;

    @Before public void setUp() throws Exception {
        multipleOutput = new MultipleOutput(output1, output2);
    }

    @Test public void shouldWriteToMultipleOutputs() {
        multipleOutput.writeChar(new TranslatableCharacter('a'));
        multipleOutput.writeChar(new TranslatableCharacter('b'));
        multipleOutput.writeChar(new TranslatableCharacter('c'));
        output1.shouldHavePrinted("abc");
        output2.shouldHavePrinted("abc");
    }
}
