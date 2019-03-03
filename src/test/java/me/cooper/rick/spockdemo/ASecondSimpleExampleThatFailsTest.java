package me.cooper.rick.spockdemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("unless you want to fail")
public class ASecondSimpleExampleThatFailsTest {

  private static final CrapCalc calc = new CrapCalc();

  @Test
  public void add_givenOneAndTwo_returnsFour() {
    // Given: nothing... given nothing

    // When: adding 1 and 2 together
    final int answer = calc.add(1, 2);

    // Then: the numbers are magically added to get ...4?!!
    assertThat(answer).isEqualTo(4);
  }

  @Test
  public void checkingStringEquality() {
    // Given: some almost identical strings
    final String one = "I want to compare this string to another string";
    final String two = "I want to compare this string too another string";

    // Then: they equal! Or do they...?
    assertThat(one).isEqualTo(two);
  }
}
