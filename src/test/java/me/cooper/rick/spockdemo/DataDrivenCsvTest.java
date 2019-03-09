package me.cooper.rick.spockdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class DataDrivenCsvTest {

  private static final CrapCalc crapCalc = new CrapCalc();

  @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
  @ParameterizedTest(name = "{0} + {1} + {2} + {3} + {4} + {5} + {6} + {7} + {8} + {9} = {10}")
  public void addAll_givenArrayOfInputs_addsThemAllUp(int x, int y, int z, int a, int b, int c, int d, int e, int f,
      int g, int expectedOutput) {
    assertEquals(crapCalc.addAll(x, y, z, a, b, c, d, e, f, g), expectedOutput);
  }

}
