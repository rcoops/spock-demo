package me.cooper.rick.spockdemo.helper;

import static java.util.Collections.singleton;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

public class CsvHelperJava {

  public static Collection<List<int[]>> getTestData() throws IOException {
    List<int[]> records = new ArrayList<>();
    String record;
    BufferedReader file = new BufferedReader(new FileReader(new ClassPathResource("test-data.csv").getFile()));
    file.readLine();
    while ((record = file.readLine()) != null) {
      records.add(Arrays.stream(record.split(",")).mapToInt(Integer::parseInt).toArray());
    }
    file.close();
    return singleton(records);
  }
}
