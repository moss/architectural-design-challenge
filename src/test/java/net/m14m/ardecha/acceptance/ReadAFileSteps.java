package net.m14m.ardecha.acceptance;

import net.m14m.ardecha.application.*;
import net.m14m.ardecha.input.FakeInputRepository;
import net.m14m.ardecha.output.FakeOutputFileRepository;
import org.jbehave.scenario.annotations.*;
import org.jbehave.scenario.errors.PendingError;
import org.jbehave.scenario.steps.Steps;

import java.io.*;

import static org.junit.Assert.*;

public class ReadAFileSteps extends Steps {
    private FakeInputRepository inputRepository;
    private ByteArrayOutputStream outputStream;
    private FakeOutputFileRepository outputRepository;

    @BeforeScenario public void setUpFakeIOEnvironment() {
        inputRepository = new FakeInputRepository();
        outputRepository = new FakeOutputFileRepository();
        outputStream = new ByteArrayOutputStream();
    }

    @Given("a file \"$filename\" containing \"$content\"")
    public void createFile(String filename, String content) {
        inputRepository.createFile(filename, content);
    }

    @When("I execute \"rot13 $inputFile $outputFile\"")
    public void runApplication(String inputFile, String outputFile) throws IOException {
        Rot13Application application = new Rot13ApplicationFactory()
                .withInputRepository(inputRepository)
                .withOutputRepository(outputRepository)
                .withOutputStream(new PrintStream(outputStream))
                .create();
        application.run(inputFile, outputFile);
    }

    @Then("it should print \"$output\"")
    public void checkOutput(String expectedOutput) throws UnsupportedEncodingException {
        assertEquals(expectedOutput, outputStream.toString("utf-8").trim());
    }

    @Then("there should be a file named $filename containing \"$expectedContent\"")
    public void checkOutputFile(String filename, String expectedContent) {
        throw new PendingError("not passing yet");
//        outputRepository.shouldContainFile(filename, expectedContent);
    }
}
