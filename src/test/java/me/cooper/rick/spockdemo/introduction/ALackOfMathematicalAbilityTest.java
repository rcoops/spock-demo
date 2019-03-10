package me.cooper.rick.spockdemo.introduction;

import static org.assertj.core.api.Assertions.assertThat;

import static me.cooper.rick.spockdemo.Fixtures.calc;

import org.junit.Ignore;
import org.junit.Test;

public class ALackOfMathematicalAbilityTest {

  @Test
  public void square_givenANumber_returnsOne() {
    assertThat(calc.square(1)).isEqualTo(1);
  }

  @Test
  @Ignore("unless you want to fail")
  public void square_givenAnotherNumber_returnsOne() {
    assertThat(calc.square(10)).isEqualTo(1);
  }

}
