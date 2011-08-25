package net.m14m.ardecha_end_to_end_tests;

import net.m14m.ardecha.runner.Rot13ApplicationRunner;
import net.m14m.ardecha.testing_support.*;
import org.junit.*;

public class EndToEndTest {
    @Rule public final FilesystemTestFixture filesystem = new FilesystemTestFixture();
    @Rule public final SystemOutFixture systemOut = new SystemOutFixture();

    @Test public void shouldPrintTheRot13dTextOfTheFile() throws Exception {
        filesystem.givenAFile("in.txt", "The dog barks at midnight.");
        Rot13ApplicationRunner.main("in.txt", "ignored-output.txt");
        systemOut.thenTheScreenShouldDisplay("Gur qbt onexf ng zvqavtug.");
    }

    @Test public void shouldWriteTheRot13dTextToAnotherFile() throws Exception {
        filesystem.givenAFile("in.txt", "The dog barks at midnight.");
        Rot13ApplicationRunner.main("in.txt", "out.txt");
        filesystem.thenAFileShouldBeCreated("out.txt", "Gur qbt onexf ng zvqavtug.");
    }
}
