package net.m14m.ardecha.acceptance;

import org.jbehave.scenario.annotations.*;
import org.jbehave.scenario.errors.PendingError;
import org.jbehave.scenario.steps.Steps;

public class ReadAFileSteps extends Steps {
    @Given("a file \"$filename\" containing \"$content\"")
    public void createFile(String filename, String content) {
        throw new PendingError("Step not yet implemented");
    }

    @When("I execute \"rot13 $inputFile\"")
    public void runApplication(String inputFile) {
        throw new PendingError("Step not yet implemented");
    }

    @Then("it should print \"$output\"")
    public void checkOutput(String expectedOutput) {
        throw new PendingError("Step not yet implemented");
    }
}
