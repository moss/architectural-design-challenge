package net.m14m.ardecha;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class Rot13ApplicationTest {
    private static final String INPUT_FILENAME = "in.txt";
    private static final String OUTPUT_FILENAME = "out.txt";
    @Mock private FileRepository fileRepository;
    @Mock private OutputRepository outputRepository;
    @Mock private TextFile inputFile;
    @Mock private Output output;
    private Rot13Application application;

    @Before public void setUpApplication() {
        application = new Rot13Application(fileRepository, outputRepository);
    }

    @Test public void shouldWriteTheRequestedFileToTheOutput() {
        given(fileRepository.loadFile(INPUT_FILENAME)).willReturn(inputFile);
        given(outputRepository.createOutput(OUTPUT_FILENAME)).willReturn(output);

        application.run(INPUT_FILENAME, OUTPUT_FILENAME);

        verify(inputFile).writeTo(output);
    }
}
