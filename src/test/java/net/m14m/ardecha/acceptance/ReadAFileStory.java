package net.m14m.ardecha.acceptance;

import org.jbehave.scenario.*;
import org.jbehave.scenario.parser.*;

public class ReadAFileStory extends JUnitScenario {
    public ReadAFileStory() {
        super(new MostUsefulConfiguration() {
            @Override public ScenarioDefiner forDefiningScenarios() {
                return new ClasspathScenarioDefiner(
                        new UnderscoredCamelCaseResolver(".story").removeFromClassname("Story"),
                        new PatternScenarioParser(keywords()));
            }
        });
    }
}
