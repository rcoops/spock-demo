package me.cooper.rick.spockdemo;

public class ClassToMockWrapper {

  private final ClassToMock mock;

  public ClassToMockWrapper(final ClassToMock mock) {
    this.mock = mock;
  }

  public ClassToMock getMock() {
    return mock;
  }

  public void doStuffWithMock() {
    mock.doStuff();
  }

}
