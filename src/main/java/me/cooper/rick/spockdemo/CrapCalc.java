package me.cooper.rick.spockdemo;

public class CrapCalc {

  public CrapCalc() {
  }

  public int add(final int one, final int two) {
    return one + two;
  }

  public int subtract(final int one, final int two) {
    return one - two;
  }

  public int multiply(final int one, final int two) {
    return one * two;
  }

  public double divide(final int one, final int two) {
    return one / (double) two;
  }
}
