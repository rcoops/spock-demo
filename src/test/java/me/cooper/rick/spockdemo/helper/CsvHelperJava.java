package me.cooper.rick.spockdemo.helper;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class CsvHelperJava {

  private CsvHelperJava() {
  }

  public static Collection<Object[]> getTestData() throws IOException {
    try (final BufferedReader br = bufferedReader()) {
      return asList(
          br.lines()
              .skip(1) // Headers
              .map(line -> stream(line.split(",")).map(Integer::parseInt).toArray(Integer[]::new))
              .toArray(Object[][]::new)
      );
    }
  }

  private static BufferedReader bufferedReader() {
    return new BufferedReader(
        new InputStreamReader(requireNonNull(CsvHelperJava.class.getClassLoader().getResourceAsStream("test-data.csv")))
    );
  }
}
