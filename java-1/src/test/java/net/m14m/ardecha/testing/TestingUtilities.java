package net.m14m.ardecha.testing;

import static org.junit.Assert.*;

public class TestingUtilities {
    public static void failUnless(boolean operationSucceeded, String message) {
        if (!operationSucceeded) fail(message);
    }

    private TestingUtilities() {}
}
