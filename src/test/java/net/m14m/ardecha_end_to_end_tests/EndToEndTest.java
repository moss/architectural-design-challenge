package net.m14m.ardecha_end_to_end_tests;

import net.m14m.ardecha.runner.Rot13ApplicationRunner;
import net.m14m.ardecha.testing_support.*;
import org.junit.*;

import java.io.IOException;

public class EndToEndTest {
    @Rule public final FilesystemTestFixture filesystem = new FilesystemTestFixture();
    @Rule public final SystemOutFixture systemOut = new SystemOutFixture();

    @Test public void shouldPrintTheRot13dTextOfTheFile() throws Exception {
        givenAFile("in.txt", "The dog barks at midnight.");
        whenIRunTheRot13CommandWith("in.txt", "ignored-output.txt");
        thenTheScreenShouldDisplay("Gur qbt onexf ng zvqavtug.");
    }

    @Test public void shouldWriteTheRot13dTextToAnotherFile() throws Exception {
        givenAFile("in.txt", "The dog barks at midnight.");
        whenIRunTheRot13CommandWith("in.txt", "out.txt");
        thenAFileShouldBeCreated("out.txt", "Gur qbt onexf ng zvqavtug.");
    }

    private void givenAFile(String name, String content) throws Exception {
        filesystem.givenAFile(name, content);
    }

    private void whenIRunTheRot13CommandWith(String... args) throws IOException {
        Rot13ApplicationRunner.main(args);
    }

    private void thenTheScreenShouldDisplay(String expectedOutput) throws Exception {
        systemOut.thenTheScreenShouldDisplay(expectedOutput);
    }

    private void thenAFileShouldBeCreated(String name, String expectedContent) throws Exception {
        filesystem.thenAFileShouldBeCreated(name, expectedContent);
    }
}
