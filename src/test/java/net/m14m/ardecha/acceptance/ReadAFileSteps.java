package net.m14m.ardecha.acceptance;

import net.m14m.ardecha.application.*;
import net.m14m.ardecha.input.FakeInputRepository;
import org.jbehave.scenario.annotations.*;
import org.jbehave.scenario.steps.Steps;

import java.io.*;

import static org.junit.Assert.*;

public class ReadAFileSteps extends Steps {
    private FakeInputRepository repository;
    private ByteArrayOutputStream outputStream;

    @BeforeScenario public void setUpFakeIOEnvironment() {
        repository = new FakeInputRepository();
        outputStream = new ByteArrayOutputStream();
    }

    @Given("a file \"$filename\" containing \"$content\"")
    public void createFile(String filename, String content) {
        repository.createFile(filename, content);
    }

    @When("I execute \"rot13 $inputFile\"")
    public void runApplication(String inputFile) throws IOException {
        Rot13Application application = new Rot13ApplicationFactory()
                .withRepository(repository)
                .withOutputStream(new PrintStream(outputStream))
                .create();
        application.run(inputFile);
    }

    @Then("it should print \"$output\"")
    public void checkOutput(String expectedOutput) throws UnsupportedEncodingException {
        assertEquals(expectedOutput, outputStream.toString("utf-8").trim());
    }
}
