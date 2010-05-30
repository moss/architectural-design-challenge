package net.m14m.ardecha.acceptance;

import net.m14m.ardecha.application.Rot13Application;
import net.m14m.ardecha.input.FakeFileRepository;
import net.m14m.ardecha.output.FakeOutput;
import org.jbehave.scenario.annotations.*;
import org.jbehave.scenario.steps.Steps;

public class ReadAFileSteps extends Steps {
    private FakeFileRepository repository;
    private FakeOutput output;

    @BeforeScenario public void setUpFakeIOEnvironment() {
        repository = new FakeFileRepository();
        output = new FakeOutput();
    }

    @Given("a file \"$filename\" containing \"$content\"")
    public void createFile(String filename, String content) {
        repository.createFile(filename, content);
    }

    @When("I execute \"rot13 $inputFile\"")
    public void runApplication(String inputFile) {
        new Rot13Application(repository, output).translate(inputFile);
    }

    @Then("it should print \"$output\"")
    public void checkOutput(String expectedOutput) {
        output.shouldHavePrinted(expectedOutput);
    }
}
