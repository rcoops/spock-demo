package me.cooper.rick.spockdemo.interaction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import me.cooper.rick.spockdemo.CrapCalc;

@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

  @Spy
  private CrapCalc calc;

  @Test
  public void addAll_arrayOfLength_addsLengthMinusOneTimes() {
    // given: an array of number summing 6
    final int[] numbers = new int[] {1, 2, 3};

    // when: adding them all
    final int result = calc.addAll(numbers);

    // then: add is performed one less time than the size of the array
    verify(calc, times(numbers.length - 1)).add(anyInt(), anyInt());
    // and: the result is the sum of the array
    assertThat(result).isEqualTo(6);
  }
}
