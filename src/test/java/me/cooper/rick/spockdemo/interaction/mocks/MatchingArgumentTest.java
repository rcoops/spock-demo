package me.cooper.rick.spockdemo.interaction.mocks;

import static org.mockito.AdditionalMatchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import me.cooper.rick.spockdemo.MockWrapper;
import me.cooper.rick.spockdemo.Mockable;

@RunWith(MockitoJUnitRunner.class)
public class MatchingArgumentTest {

  @Mock
  private Mockable mockyMock;

  private static MockWrapper mockyMockWrapper;

  @Before
  public void beforeEach() {
    mockyMockWrapper = new MockWrapper(mockyMock);
  }

  @Test
  public void doStuff_callsDoStuff_withOneArg() {
    // when: doing stuff with the string
    mockyMockWrapper.doStuff("hello world!");

    // then: stuff is done
    verify(mockyMock).doStuff(anyString()); // Forces you to care about the arg
  }

  @Test
  public void doStuffWithArgs_callsDoStuff_withThreeArgs() {
    // when: doing stuff with the string
    mockyMockWrapper.doStuffWithArgs();

    // then: stuff is done with exactly three things
    verify(mockyMock).doStuff(any(), anyInt(), any()); // Forces you to care about the arg
  }

  @Test
  public void doStuffWithArgs_callsDoStuff_withArgsThatFulfillConditions() {
    // when: doing stuff with the string
    mockyMockWrapper.doStuffWithArgs();

    // then: stuff is done with exactly three things
    verify(mockyMock)
        .doStuff(eq("Hello World!"), gt(2), not(eq(6.0f)));
  }

  @Test
  public void doStuffWithArgs_callsDoStuff_withArgsThatFulfillOtherConditions() {
    // when: doing stuff with the string
    mockyMockWrapper.doStuffWithArgs();

    // then: stuff is done with exactly three things
    verify(mockyMock)
        .doStuff(isA(String.class), and(gt(0), lt(20)), isNotNull());
  }
}
