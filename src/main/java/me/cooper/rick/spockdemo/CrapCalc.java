package me.cooper.rick.spockdemo;

import static java.util.Arrays.stream;

public class CrapCalc {

  private final String youCantSeeMe = "ha!";

  public CrapCalc() {
  }

  public int add(final int one, final int two) {
    return one + two;
  }

  public int addAll(final int... all) {
    return stream(all).sum();
  }
}
