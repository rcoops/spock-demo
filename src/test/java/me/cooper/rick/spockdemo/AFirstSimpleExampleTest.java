package me.cooper.rick.spockdemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AFirstSimpleExampleTest {

  private static final CrapCalc calc = new CrapCalc();

  @Test
  public void add_givenOneAndTwo_returnsThree() {
    // Given: nothing... given nothing

    // When: adding 1 and 2 together
    final int answer = calc.add(1, 2);

    // Then: the numbers are magically added to get 3!!
    assertThat(answer).isEqualTo(3);
  }

  @Test
  public void add_givenOneAndTwo_expectThree() {

    // Expect: 1 and 2 added together makes...3!
    assertThat(calc.add(1, 2)).isEqualTo(3);
  }

}
