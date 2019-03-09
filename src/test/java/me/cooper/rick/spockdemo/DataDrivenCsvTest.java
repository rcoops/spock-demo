package me.cooper.rick.spockdemo;

import static org.junit.Assert.assertEquals;

import static me.cooper.rick.spockdemo.helper.CsvHelperJava.getTestData;
import static org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DataDrivenCsvTest {

  @Parameters
  public static Collection<Object[]> params() throws IOException {
    return getTestData();
  }

  private final int x;
  private final int y;
  private final int z;
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int expectedAnswer;

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
      assertEquals(new CrapCalc().addAll(x, y, z, a, b, c, d, e, f, g), expectedAnswer);
  }
}
