package me.cooper.rick.spockdemo;

import static java.lang.String.format;

public class Mockable {

  public void doStuff() {

  }

  public void doOtherStuff() {
  }

  public String getStuff() {
    return "Hello World!";
  }

  public void doStuff(final int number) {

  }

  public void doStuff(final String string) {

  }

  public void doStuff(final String string, final int number, final Float real) {

  }

  public void doStuff(final SomeArgs someArgs) {

  }

  public void doStuffWithMaxSizeInt(final int noBiggerThanTen) {
    if (noBiggerThanTen > 10) {
      throw new IllegalArgumentException(format("%d may not be greater than 10", noBiggerThanTen));
    }
  }
}
