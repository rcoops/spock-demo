package me.cooper.rick.spockdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class DataDrivenBetterTest {

  private static final CrapCalc crapCalc = new CrapCalc();

  @CsvSource({
      "1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  10",
      "2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  20",
      "3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  30",
      "4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  40",
      "5,  5,  5,  5,  5,  5,  5,  5,  5,  5,  50",
      "6,  6,  6,  6,  6,  6,  6,  6,  6,  6,  60",
      "7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  70",
      "8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  80",
      "9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  90",
      "10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 100"
  })
  @ParameterizedTest(name = "{0} + {1} + {2} + {3} + {4} + {5} + {6} + {7} + {8} + {9} = {10}")
  public void addAll_givenArrayOfInputs_addsThemAllUp(int x, int y, int z, int a, int b, int c, int d, int e, int f,
      int g, int expectedOutput) {
    assertEquals(crapCalc.addAll(x, y, z, a, b, c, d, e, f, g), expectedOutput);
  }



  @Test
  @Parameters({
      "1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  10",
      "2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  20",
      "3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  30",
      "4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  40",
      "5,  5,  5,  5,  5,  5,  5,  5,  5,  5,  50",
      "6,  6,  6,  6,  6,  6,  6,  6,  6,  6,  60",
      "7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  70",
      "8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  80",
      "9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  90",
      "10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 100"
  })
  public void addAll_givenArrayOfInputs_addsThemAllUpParams(int x, int y, int z, int a, int b, int c, int d, int e, int f,
      int g, int expectedOutput) {
    assertEquals(crapCalc.addAll(x, y, z, a, b, c, d, e, f, g), expectedOutput);
  }

}
