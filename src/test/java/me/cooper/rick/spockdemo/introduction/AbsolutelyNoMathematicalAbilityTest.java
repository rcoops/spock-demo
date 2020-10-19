package me.cooper.rick.spockdemo.introduction;

import static org.assertj.core.api.Assertions.assertThat;

import static me.cooper.rick.spockdemo.Fixtures.calc;

import org.junit.Ignore;
import org.junit.Test;

public class AbsolutelyNoMathematicalAbilityTest {

  // 100% code coverage!! YAY!
  @Test
  public void square_givenANumber_returnsItsSquare() {
    assertThat(calc.square(10)).isEqualTo(100);
  }

  @Test
  public void square_givenAnotherNumber_returnsItsSquare() {
    assertThat(calc.square(5)).isEqualTo(100);
  }
}
