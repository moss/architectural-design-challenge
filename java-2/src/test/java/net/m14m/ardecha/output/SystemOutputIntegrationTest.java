package net.m14m.ardecha.output;

import net.m14m.ardecha.Output;
import net.m14m.ardecha.testing_support.SystemOutFixture;
import org.junit.*;

public class SystemOutputIntegrationTest {
    @Rule public SystemOutFixture systemOut = new SystemOutFixture();
    private Output output = new SystemOutput();

    @Test public void shouldPassItsOutputOnToSystemOut() throws Exception {
        output.write('a');
        output.write('b');
        output.write('c');

        systemOut.thenTheScreenShouldDisplay("abc");
    }
}
