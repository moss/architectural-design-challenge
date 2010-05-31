package net.m14m.ardecha.application;

import net.m14m.ardecha.input.FakeInputRepository;
import net.m14m.ardecha.output.FakeOutput;
import org.junit.*;

public class Rot13ApplicationTest {
    private static final String FILENAME = "sample.txt";
    private FakeInputRepository repository = new FakeInputRepository();
    private FakeOutput output = new FakeOutput();
    private Rot13Application application;

    @Before public void setUp() throws Exception {
        application = new Rot13Application(repository, output);
    }

    @Test public void shouldPrintInputToOutput() {
        repository.createFile(FILENAME, "some text");
        application.translate(FILENAME);
        output.shouldHavePrinted("some text");
    }
}
