package net.m14m.ardecha.acceptance;

import net.m14m.ardecha.application.Rot13ApplicationRunner;
import net.m14m.ardecha.input.FakeInputRepository;
import net.m14m.ardecha.output.FakeOutputFileRepository;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

import java.io.*;

import static org.junit.Assert.*;

@SuppressWarnings({"FeatureEnvy"})
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
        new Rot13ApplicationRunner()
                .withInputRepository(inputRepository)
                .withOutputRepository(outputRepository)
                .withSystemOutputStream(new PrintStream(outputStream))
                .run(inputFile, outputFile);
    }

    @Then("it should print \"$output\"")
    public void checkOutput(String expectedOutput) throws UnsupportedEncodingException {
        assertEquals(expectedOutput, outputStream.toString("utf-8").trim());
    }

    @Then("there should be a file named $filename containing \"$expectedContent\"")
    public void checkOutputFile(String filename, String expectedContent) {
        outputRepository.shouldContainFile(filename, expectedContent);
    }
}
