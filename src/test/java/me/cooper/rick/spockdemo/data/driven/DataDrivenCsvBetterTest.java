package me.cooper.rick.spockdemo.data.driven;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.mappers.CsvWithHeaderMapper;
import me.cooper.rick.spockdemo.CrapCalc;

@RunWith(JUnitParamsRunner.class)
public class DataDrivenCsvBetterTest {

  private static final CrapCalc calc = new CrapCalc();

  @Rule
  public MockitoRule mockito = MockitoJUnit.rule();

  @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
  @ParameterizedTest(name = "{0} + {1} + {2} + {3} + {4} + {5} + {6} + {7} + {8} + {9} = {10}")
  public void addAll_givenArrayOfInputs_addsThemAllUpWithJUnit5(int x, int y, int z, int a, int b, int c, int d, int e,
      int f, int g, int expectedAnswer) {
    assertEquals(calc.addAll(x, y, z, a, b, c, d, e, f, g), expectedAnswer);
  }

  @Test
  @FileParameters(value = "src/test/resources/test-data.csv", mapper = CsvWithHeaderMapper.class)
  public void addAll_givenArrayOfInputs_addsThemAllUpWithJUnitParams(final int x, final int y, final int z, final int a,
      final int b, final int c, final int d, final int e, final int f, final int g, final int expectedAnswer) {
    Assert.assertEquals(calc.addAll(x, y, z, a, b, c, d, e, f, g), expectedAnswer);
  }
}
