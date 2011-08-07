package net.m14m.ardecha_end_to_end_tests;

import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnvironmentSetupTest {
    @Test public void iShouldBeAbleToRunATest() {
        assertTrue("this should pass", true);
        assertFalse("but this should fail", true);
    }
}
