package me.cooper.rick.spockdemo.data.driven;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

import static me.cooper.rick.spockdemo.Fixtures.calc;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AwfulTest {

  @Parameters(name = "{0} + {1} = {2}")
  public static Collection<Object[]> params() {
      return asList(
          new Object[][]{
              {1, 1, 3},
              {2, 2, 4},
              {3, 3, 6}
          }
      );
  }

  private final int firstInput;
  private final int secondInput;
  private final int expectedOutput;

  public AwfulTest(final int firstInput, final int secondInput, final int expectedOutput) {
    this.firstInput = firstInput;
    this.secondInput = secondInput;
    this.expectedOutput = expectedOutput;
  }

  @Test
  public void addAll_givenArrayOfInputs_addsThemAllUp() {
    // when: adding x and y
    int result = calc.add(firstInput, secondInput);

    // then: the answer should be as expected
    assertEquals(result, expectedOutput);
  }
}
