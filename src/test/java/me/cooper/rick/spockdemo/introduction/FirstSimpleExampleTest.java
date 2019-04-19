package me.cooper.rick.spockdemo.introduction;

import static org.assertj.core.api.Assertions.assertThat;

import static me.cooper.rick.spockdemo.Fixtures.calc;

import org.junit.Test;

public class FirstSimpleExampleTest {

  @Test
  public void add_givenOneAndTwo_returnsThree() {
    // given: nothing... given nothing

    // when: adding 1 and 2 together
    final int answer = calc.add(1, 2);

    // then: the numbers are magically added to get 3!!
    assertThat(answer).isEqualTo(3);
  }

  @Test
  public void add_givenOneAndTwo_expectThree() {

    // expect: 1 and 2 added together makes...3!
    assertThat(calc.add(1, 2)).isEqualTo(3);
  }
}
