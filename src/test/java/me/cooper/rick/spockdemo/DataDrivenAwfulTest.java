package me.cooper.rick.spockdemo;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DataDrivenAwfulTest {

  @Parameterized.Parameters
  public static Collection<Object[]> params() {
      return asList(
          new Object[][]{
              {1, 1, 2},
              {2, 2, 4},
              {3, 3, 6}
          }
      );
  }

  private final CrapCalc crapCalc = new CrapCalc();

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
    int result = crapCalc.add(firstInput, secondInput);

    // Then: the answer should be as expected
    assertEquals(result, expectedOutput);
  }

}
