package me.cooper.rick.spockdemo;

import static java.util.stream.IntStream.range;

import java.util.Random;

public class MockWrapper {

  private final Mockable mock;

  private static final Random rand = new Random();

  public MockWrapper(final Mockable mock) {
    this.mock = mock;
  }

  public Mockable getMock() {
    return mock;
  }

  public void doStuff() {
    //    mock.doStuff();
    mock.doOtherStuff();
  }

  public void doStuff(final int number) {
    mock.doStuff(number);
  }

  public void doStuff(final String string) {
    mock.doStuff(string);
  }

  public void ensureNoBiggerThanTen(final int anyInt) {
    final int checked = anyInt > 10 ? 10 : anyInt;
    mock.doStuffWithMaxSizeInt(checked);
  }

  public void doStuffRandomTimes() {
    final int times = rand.nextInt() & Integer.MAX_VALUE;
    range(1, times).forEach(i -> mock.doStuff());
  }

  public void doStuffWithMockTimes(final int times) {
    range(1, times).forEach(i -> mock.doStuff());
  }

  public void doStuffWithArgs() {
    mock.doStuff("Hello World!", 5, 1.0f);
  }

}
