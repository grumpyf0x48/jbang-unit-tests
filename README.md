# jbang-unit-tests

Source files for blog post on [JBang and unit tests](https://grumpyf0x48.org/jbang-et-les-tests-unitaires/).

## Run Fibonacci tests

```console
$ jbang FibonacciTest.java
```

## Edit Fibonacci code (production and tests)

```console
$ jbang edit FibonacciTest.java
```

## Generate a test class

For a script called `Feature.java`:

```console
$ jbang init --template=junit@jbangdev Feature.java
```
