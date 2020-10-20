package me.cooper.rick.spockdemo.data.driven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import static me.cooper.rick.spockdemo.Fixtures.calc;

import java.util.stream.Stream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import junitparams.JUnitParamsRunner;
import junitparams.NamedParameters;
import junitparams.Parameters;

@SuppressWarnings("all")
@RunWith(JUnitParamsRunner.class)
public class BetterTest {

  @Rule
  public final MockitoRule mockitoRule = MockitoJUnit.rule();

  /*
   * JUnit 5
   */

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

    assertEquals(calc.addAll(x, y, z, a, b, c, d, e, f, g), expectedOutput);
  }

  @MethodSource("params")
  @ParameterizedTest(name = "{0} + {1} + {2} + {3} + {4} + {5} + {6} + {7} + {8} + {9} = {10}")
  public void addAll_givenArrayOfInputs_addsThemAllUpMethodProvider(int x, int y, int z, int a, int b, int c, int d,
      int e, int f, int g, int expectedOutput) {

    assertEquals(calc.addAll(x, y, z, a, b, c, d, e, f, g), expectedOutput);
  }

  private static Stream<Arguments> params() {
    return Stream.of(
        //@formatter:off
        arguments(1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  11),
        arguments(2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  20),
        arguments(3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  30),
        arguments(4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  40),
        arguments(5,  5,  5,  5,  5,  5,  5,  5,  5,  5,  50),
        arguments(6,  6,  6,  6,  6,  6,  6,  6,  6,  6,  60),
        arguments(7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  70),
        arguments(8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  80),
        arguments(9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  90) ,
        arguments(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 100)
        //@formatter:on
    );
  }

  /*
   * JUnitParams
   */

  @Test
  @Parameters({
      "1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  11",
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
  public void addAll_givenArrayOfInputs_addsThemAllUpParams(int x, int y, int z, int a, int b, int c, int d, int e,
      int f, int g, int expectedOutput) {
    assertEquals(calc.addAll(x, y, z, a, b, c, d, e, f, g), expectedOutput);
  }

  @Test
  @Parameters(named = "params")
  public void addAll_givenArrayOfInputs_addsThemAllUpParamsNamed(int x, int y, int z, int a, int b, int c, int d,
      int e, int f, int g, int expectedOutput) {
    assertEquals(calc.addAll(x, y, z, a, b, c, d, e, f, g), expectedOutput);
  }

  @Test
  @Parameters
  public void addAll_givenArrayOfInputs_addsThemAllUpParamsProvider(int x, int y, int z, int a, int b, int c, int d,
      int e, int f, int g, int expectedOutput) {
    assertEquals(calc.addAll(x, y, z, a, b, c, d, e, f, g), expectedOutput);
  }

  private static Object[] parametersForAddAll_givenArrayOfInputs_addsThemAllUpParamsProvider() {
    return namedParams();
  }

  @NamedParameters("params")
  private static Object[] namedParams() {
    return new Object[] {
        //@formatter:off
        new Object[] { 1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  10  },
        new Object[] { 2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  20  },
        new Object[] { 3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  30  },
        new Object[] { 4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  40  },
        new Object[] { 5,  5,  5,  5,  5,  5,  5,  5,  5,  5,  50  },
        new Object[] { 6,  6,  6,  6,  6,  6,  6,  6,  6,  6,  60  },
        new Object[] { 7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  70  },
        new Object[] { 8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  80  },
        new Object[] { 9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  90  } ,
        new Object[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 100 }
        //@formatter:on
    };
  }

}
