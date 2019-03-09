package me.cooper.rick.spockdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;

@RunWith(JUnitParamsRunner.class)
public class DataDrivenCsvJUnitParamsTest {

  private static final CrapCalc calc = new CrapCalc();

  @Test
  @FileParameters(value = "src/test/resources/test-data.csv", mapper = CsvWithHeaderMapper.class)
  public void addAll_givenArrayOfInputs_addsThemAllUp(final int x, final int y, final int z, final int a, final int b,
      final int c, final int d, final int e, final int f, final int g, final int expectedAnswer) {
    assertEquals(calc.addAll(x, y, z, a, b, c, d, e, f, g), expectedAnswer);
  }
}
