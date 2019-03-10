package me.cooper.rick.spockdemo.data.driven;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import me.cooper.rick.spockdemo.CrapCalc;

@RunWith(Parameterized.class)
public class DataDrivenAwfulTest {

  @Parameters(name = "{0} + {1} = {2}")
  public static Collection<Object[]> params() {
      return asList(
          new Object[][]{
              {1, 1, 2},
              {2, 2, 4},
              {3, 3, 6}
          }
      );
  }

  private int firstInput;
  private int secondInput;
  private int expectedOutput;

  public DataDrivenAwfulTest(final int firstInput, int secondInput, final int expectedOutput) {
    this.firstInput = firstInput;
    this.secondInput = secondInput;
    this.expectedOutput = expectedOutput;
  }

  @Test
  public void addAll_givenArrayOfInputs_addsThemAllUp() {
    // When: adding x and y
    int result = new CrapCalc().add(firstInput, secondInput);

    // Then: the answer should be as expected
    assertEquals(result, expectedOutput);
  }

}
