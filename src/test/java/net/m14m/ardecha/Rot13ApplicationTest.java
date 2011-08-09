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
    @Mock private FileRepository fileRepository;
    @Mock private TextFile inputFile;
    @Mock private Output output;
    private Rot13Application application;

    @Before public void setUpApplication() {
        application = new Rot13Application(fileRepository, output);
    }

    @Test public void shouldWriteTheRequestedFileToTheOutput() {
        given(fileRepository.loadFile(INPUT_FILENAME)).willReturn(inputFile);
        application.rot13(INPUT_FILENAME);
        verify(inputFile).writeTo(output);
    }
}
