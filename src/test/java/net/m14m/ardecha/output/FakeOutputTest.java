package net.m14m.ardecha.output;

public class FakeOutputTest extends OutputContract {
    private FakeOutput fakeOutput = new FakeOutput();

    @Override protected Output getOutput() {
        return fakeOutput;
    }

    @Override protected void shouldHavePrinted(String expectedOutput) {
        fakeOutput.shouldHavePrinted(expectedOutput);
    }
}
