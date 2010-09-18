package net.m14m.ardecha.acceptance;

import org.jbehave.core.configuration.*;
import org.jbehave.core.io.*;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.*;

import static org.jbehave.core.reporters.StoryReporterBuilder.Format.CONSOLE;

public class ReadAFileStory extends JUnitStory {
    public ReadAFileStory() {
        StoryPathResolver storyPathResolver = new UnderscoredCamelCaseResolver(".story")
                .removeFromClassName("Story");
        Configuration configuration = new MostUsefulConfiguration()
                .useStoryReporterBuilder(
                        new SaneStoryReporterBuilder().withFormats(CONSOLE)
                )
                .useStoryPathResolver(storyPathResolver);
        useConfiguration(configuration);
        addSteps(new ReadAFileSteps());
    }

    private static class SaneStoryReporterBuilder extends StoryReporterBuilder {
        @Override public StoryReporter reporterFor(String storyPath, Format format) {
            StoryReporter reporter = super.reporterFor(storyPath, format);
            if (format == CONSOLE) reporter = new SilentSuccessFilter(reporter);
            return reporter;
        }
    }
}
