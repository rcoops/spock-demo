package me.cooper.rick.spockdemo.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

import java.util.Collection;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

public class CsvHelperJava {

  public static Collection<Object[]> getTestData() throws IOException {
    List<Integer[]> testCases = new ArrayList<>();
    String record;
    BufferedReader file = new BufferedReader(new FileReader(new ClassPathResource("test-data.csv").getFile()));
    file.readLine();
    while ((record = file.readLine()) != null) {
      testCases.add(stream(record.split(",")).map(Integer::parseInt).toArray(Integer[]::new));
    }
    file.close();
    return asList(testCases.toArray(new Object[0][0]));
  }
}
