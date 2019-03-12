package me.cooper.rick.spockdemo.data.driven;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

import static me.cooper.rick.spockdemo.Fixtures.calc;
import static me.cooper.rick.spockdemo.helper.CsvHelperJava.getTestData;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CsvBadTest {

  @Parameters(name = "{0} + {1} + {2} + {3} + {4} + {5} + {6} + {7} + {8} + {9} = {10}")
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

  public CsvBadTest(final int x, final int y, final int z, final int a, final int b, final int c, final int d,
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
