package net.m14m.ardecha.acceptance;

import org.jbehave.scenario.annotations.*;
import org.jbehave.scenario.steps.Steps;

import java.io.IOException;

public class ReadAFileSteps extends Steps {
    private FakeIOEnvironment fakeIOEnvironment;

    @BeforeScenario public void setUpFakeIOEnvironment() {
        fakeIOEnvironment = new FakeIOEnvironment();
    }

    @Given("a file \"$filename\" containing \"$content\"")
    public void createFile(String filename, String content) {
        fakeIOEnvironment.getRepository().createFile(filename, content);
    }

    @When("I execute \"rot13 $inputFile\"")
    public void runApplication(String inputFile) throws IOException {
        fakeIOEnvironment.createApplicationInFakeEnvironment().run(inputFile);
    }

    @Then("it should print \"$output\"")
    public void checkOutput(String expectedOutput) {
        fakeIOEnvironment.getOutput().shouldHavePrinted(expectedOutput);
    }
}
