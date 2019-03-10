package me.cooper.rick.spockdemo.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.ArrayList;

import static java.nio.file.Files.newBufferedReader;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.core.io.ClassPathResource;

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
        new InputStreamReader(
            requireNonNull(CsvHelperJava.class.getClassLoader().getResourceAsStream("test-data.csv"))
        )
    );
  }
}
