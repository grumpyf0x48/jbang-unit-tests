///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS org.junit.jupiter:junit-jupiter-api:5.7.2
//DEPS org.junit.jupiter:junit-jupiter-engine:5.7.2
//DEPS org.junit.platform:junit-platform-launcher:1.7.2

//SOURCES Fibonacci.java

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.LoggingListener;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

// JUnit5 Test class for Fibonacci
public class FibonacciTest {

    static Fibonacci fibonacci;

    @BeforeAll
    public static void init() {
        fibonacci = new Fibonacci();
    }

    // Define each Unit test here and run them separately in the IDE

    @Test
    public void test0() {
        assertEquals(0, fibonacci.getFibonacci(0));
    }

    @Test
    public void test1() {
        assertEquals(1, fibonacci.getFibonacci(1));
    }

    @Test
    public void test7() {
        assertEquals(13, fibonacci.getFibonacci(7));
    }

    // Run all Unit tests with JBang with ./FibonacciTest.java
    public static void main(final String... args) {
        final LauncherDiscoveryRequest request =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(FibonacciTest.class))
                        .build();
        final Launcher launcher = LauncherFactory.create();
        final LoggingListener logListener = LoggingListener.forBiConsumer((t,m) -> {
            System.out.println(m.get());
            if(t!=null) {
                t.printStackTrace();
            };
        });
        final SummaryGeneratingListener execListener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(execListener, logListener);
        launcher.execute(request);
        execListener.getSummary().printTo(new java.io.PrintWriter(out));
    }
}
