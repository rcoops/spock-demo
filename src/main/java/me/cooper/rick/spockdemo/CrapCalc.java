package me.cooper.rick.spockdemo;

import static java.util.Arrays.stream;

public final class CrapCalc {

  private final String definitelyPrivateField = "ha! you'll never see me cos: encapsulation right?";

  public CrapCalc() {
  }

  public int add(final int one, final int two) {
    return one + two;
  }

  public int addAll(final int... all) {
    return stream(all).sum();
  }
}
