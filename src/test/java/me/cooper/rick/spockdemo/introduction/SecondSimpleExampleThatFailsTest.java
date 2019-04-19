package me.cooper.rick.spockdemo.introduction;

import static org.assertj.core.api.Assertions.assertThat;

import static me.cooper.rick.spockdemo.Fixtures.calc;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("unless you want to fail")
public class SecondSimpleExampleThatFailsTest {

  @Test
  public void add_givenOneAndTwo_returnsFour() {
    // expect: adding 1 and 2 makes ...4?!!
    assertThat(calc.add(1, 2)).isEqualTo(4);
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
