package me.cooper.rick.spockdemo;

import static org.junit.Assert.assertEquals;

import static me.cooper.rick.spockdemo.helper.CsvHelperJava.getTestData;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DataDrivenCsvTest {

  private static final CrapCalc calc = new CrapCalc();

  @Parameterized.Parameters
  public static Collection<List<int[]>> testData() throws IOException {
    return getTestData();
  }

  private int x;
  private int y;
  private int z;
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int expectedAnswer;

  public DataDrivenCsvTest(final int x, final int y, final int z, final int a, final int b, final int c, final int d,
      final int e, final int f, final int g, final int expectedAnswer) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.e = e;
    this.f = f;
    this.g = g;
    this.expectedAnswer = expectedAnswer;
  }

  @Test
  public void addAll_givenArrayOfInputs_addsThemAllUp() {
      assertEquals(calc.addAll(x, y, z, a, b, c, d, e, f, g), expectedAnswer);
  }
}
