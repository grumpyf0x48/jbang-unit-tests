///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.5.0

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Command(name = "Fibonacci", mixinStandardHelpOptions = true, version = "Fibonacci 0.1", description = "Fibonacci made with jbang")
public class Fibonacci implements Callable<Integer> {

    @Parameters(index = "0", description = "Number of elements to compute")
    private int max;

    public static void main(String... args) {
        int exitCode = new CommandLine(new Fibonacci()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        List<Integer> suites = getFibonacciList(max);
        System.out.println(suites);
        return 0;
    }

    public List<Integer> getFibonacciList(int max) {
        List<Integer> suites = new ArrayList<>();
        for (int n = 0; n < max; n++) {
            suites.add(getFibonacci(n));
        }
        return suites;
    }

    public Integer getFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}
