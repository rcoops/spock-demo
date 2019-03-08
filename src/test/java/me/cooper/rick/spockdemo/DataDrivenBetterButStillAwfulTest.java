package me.cooper.rick.spockdemo;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DataDrivenBetterButStillAwfulTest {

  @Parameterized.Parameters
  public static Collection<Object[]> params() {
      return asList(
          new Object[][]{
              {new int[]{1,1,1,1,1,1,1,1,1,1}, 10},
              {new int[]{2,2,2,2,2,2,2,2,2,2}, 20},
              {new int[]{3,3,3,3,3,3,3,3,3,3}, 30}
          }
      );
  }

  private final CrapCalc crapCalc = new CrapCalc();

  private int[] addAllInputs;
  private int expectedOutput;

  public DataDrivenBetterButStillAwfulTest(final int[] addAllInputs, final int expectedOutput) {
    this.addAllInputs = addAllInputs;
    this.expectedOutput = expectedOutput;
  }

  @Test
  public void addAll_givenArrayOfInputs_addsThemAllUp() {
    assertEquals(crapCalc.addAll(addAllInputs), expectedOutput);
  }

}
