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
            FilePrintStreamFactory factory = this.filePrintStreamFactory(storyPath);
            switch (format) {
                case CONSOLE:
                default:
                    return new SilentSuccessFilter(
                            new ConsoleOutput(keywords()).doReportFailureTrace(reportFailureTrace())
                    );
                case IDE_CONSOLE:
                    return new IdeOnlyConsoleOutput(keywords())
                            .doReportFailureTrace(reportFailureTrace());
                case TXT:
                    factory.useConfiguration(fileConfiguration("txt"));
                    return new TxtOutput(factory.createPrintStream(), keywords())
                            .doReportFailureTrace(reportFailureTrace());
                case HTML:
                    factory.useConfiguration(fileConfiguration("html"));
                    return new HtmlOutput(factory.createPrintStream(), keywords())
                            .doReportFailureTrace(reportFailureTrace());
                case XML:
                    factory.useConfiguration(fileConfiguration("xml"));
                    return new XmlOutput(factory.createPrintStream(), keywords())
                            .doReportFailureTrace(reportFailureTrace());
                case STATS:
                    factory.useConfiguration(fileConfiguration("stats"));
                    return new PostStoryStatisticsCollector(factory.createPrintStream());
            }
        }
    }
}
