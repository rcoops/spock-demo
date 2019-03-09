package me.cooper.rick.spockdemo.helper;

import static java.util.Collections.singletonList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

public class CsvHelperJava {

  public static Collection<Object[]> getTestData() throws IOException {
    List<String[]> testCase = new ArrayList<>();
    String record;
    BufferedReader file = new BufferedReader(new FileReader(new ClassPathResource("test-data.csv").getFile()));
    file.readLine();
    while ((record = file.readLine()) != null) {
      testCase.add(record.split(","));
    }
    file.close();
    return singletonList(testCase.toArray());
  }
}
