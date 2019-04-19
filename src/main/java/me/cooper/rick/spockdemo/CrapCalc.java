package me.cooper.rick.spockdemo;

import static java.util.Arrays.stream;

public class CrapCalc {

  public CrapCalc() {
  }

  public int add(final int one, final int two) {
    return one + two;
  }

  public int addAll(final int... all) {
    return stream(all).reduce(this::add).orElseThrow(() -> new NumberFormatException("Something's up"));
  }

  public int square(final int number) {
    return number * number;
  }

//  public int cube(final int number) {
//    return square(number) * number;
//  }
}
