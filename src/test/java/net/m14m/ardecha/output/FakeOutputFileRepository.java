package net.m14m.ardecha.output;

import org.jbehave.scenario.errors.PendingError;

public class FakeOutputFileRepository implements OutputFileRepository {
    public void shouldContainFile(String filename, String expectedContent) {
        throw new PendingError("FakeOutputFileRepository not yet implemented");
    }
}
