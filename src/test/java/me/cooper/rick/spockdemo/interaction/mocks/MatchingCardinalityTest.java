package me.cooper.rick.spockdemo.interaction.mocks;

import static org.mockito.Mockito.*;

import org.junit.Test;

import me.cooper.rick.spockdemo.MockWrapper;
import me.cooper.rick.spockdemo.Mockable;

@SuppressWarnings("all")
public class MatchingCardinalityTest {

  private Mockable mockyMock = mock(Mockable.class);

  private final MockWrapper mockyMockWrapper = new MockWrapper(mockyMock);

  @Test
  public void doStuffTimes_threeTimes_callDelegateOnce() {
    // when: wrapper does stuff times 3
    mockyMockWrapper.doStuffTimes(1);

    // then: delegate does other stuff once
    verify(mockyMock).doOtherStuff();
  }

  @Test
  public void doStuffTimes_threeTimes_callDelegateOnceExplicitly() {
    // when: wrapper does stuff times 3
    mockyMockWrapper.doStuffTimes(1);

    // then: delegate does other stuff once... definitely once
    verify(mockyMock, times(1)).doOtherStuff();
  }

  @Test
  public void doStuffTimes_threeTimes_callDelegateAtLeastOnce() {
    // when: wrapper does stuff times 3
    mockyMockWrapper.doStuffTimes(1);

    // then: delegate does other stuff at LEAST once... maybe more!!
    verify(mockyMock, atLeastOnce()).doOtherStuff();
  }

  @Test
  public void doStuffTimes_threeTimes_callDelegateAtLeastThreeTimes() {
    // when: wrapper does stuff times 3
    mockyMockWrapper.doStuffTimes(3);

    // then: delegate does other stuff at least three times
    verify(mockyMock, atLeast(3)).doOtherStuff();
  }

  @Test
  public void doStuffTimes_threeTimes_callDelegateNoMoreThanFiveTimes() {
    // when: wrapper does stuff times 3
    mockyMockWrapper.doStuffTimes(3);

    // then: delegate does other stuff no more than five times
    verify(mockyMock, atMost(5)).doOtherStuff();
  }

  @Test
  public void doStuffTimes_threeTimes_callDelegateBetweenTwoAndFourTimes() {
    // when: wrapper does stuff times 3
    mockyMockWrapper.doStuffTimes(3);

    // then: delegate does other stuff between two and four times
    verify(mockyMock, atLeast(2)).doOtherStuff();
    verify(mockyMock, atMost(4)).doOtherStuff();
  }

  @Test
  public void doStuffTimes_zeroTimes_doesNotCallDelegate() {
    // when: wrapper does stuff times ZERO!
    mockyMockWrapper.doStuffTimes(0);

    // then: delegate does other stuff between two and four times
    verify(mockyMock, never()).doOtherStuff();
  }

  @Test
  public void doStuffTimes_oneTimes_callsDelegateOnceOnly() {
    // when: wrapper does stuff times 1
    mockyMockWrapper.doStuffTimes(1);

    // then: delegate does other stuff and is the only one to do anything
    verify(mockyMock, only()).doOtherStuff();
  }

  @Test
  public void doStuffTimes_threeTimes_callsDelegateThreeTimesAndThenNoMoreInteractions() {
    // when: wrapper does stuff times 3
    mockyMockWrapper.doStuffTimes(3);

    // then: delegate does other stuff three times
    verify(mockyMock, times(3)).doOtherStuff();
    // and: nothing else happens
    verifyNoMoreInteractions(mockyMock);
  }

  @Test
  public void doStuffTimes_zeroTimes_callsDelegateOnceOnlyNoMoreInteractions() {
    // when: wrapper does stuff times ZERO!
    mockyMockWrapper.doStuffTimes(0);

    // then: nothing else happens
    verifyZeroInteractions(mockyMock); // ...etc.
  }
}
