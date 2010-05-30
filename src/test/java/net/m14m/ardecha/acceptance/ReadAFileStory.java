package net.m14m.ardecha.acceptance;

import org.jbehave.scenario.*;
import org.jbehave.scenario.parser.*;

public class ReadAFileStory extends JUnitScenario {
    public ReadAFileStory() {
        super(new ArdechaConfiguration(), new ReadAFileSteps());
    }

    private static class ArdechaConfiguration extends MostUsefulConfiguration {
        @Override public ScenarioDefiner forDefiningScenarios() {
            return new ClasspathScenarioDefiner(
                    new UnderscoredCamelCaseResolver(".story").removeFromClassname("Story"),
                    new PatternScenarioParser(keywords()));
        }
    }
}
