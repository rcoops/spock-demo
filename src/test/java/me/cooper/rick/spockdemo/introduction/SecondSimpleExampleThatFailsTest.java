package me.cooper.rick.spockdemo.introduction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import static me.cooper.rick.spockdemo.Fixtures.calc;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("unless you want to fail")
public class SecondSimpleExampleThatFailsTest {

  @Test
  public void add_givenOneAndOne_returnsThree() {
    // expect: adding 1 and 1 makes ...3?!!
    assertThat(calc.add(1, 1)).isEqualTo(3);
  }

  @Test
  public void checkingStringEquality() {
    // given: some almost identical strings
    final String one = "I want to compare this string to another string";
    final String two = "I want to compare this string too another string";

    // expect: they equal! Or do they...?
    assertThat(one).isEqualTo(two);
  }
}
