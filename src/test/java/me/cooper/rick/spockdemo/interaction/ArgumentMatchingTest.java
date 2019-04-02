package me.cooper.rick.spockdemo.interaction;

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
public class ArgumentMatchingTest {

  @Mock
  private Mockable mockyMock;

  private static MockWrapper mockyMockWrapper;

  @Before
  public void beforeEach() {
    mockyMockWrapper = new MockWrapper(mockyMock);
  }

  @Test
  public void doStuff_callsDoStuff_withOneArg() {
    // When: doing stuff with the string
    mockyMockWrapper.doStuff("hello world!");

    // Then: stuff is done
    verify(mockyMock).doStuff(anyString()); // Forces you to care about the arg
  }

  @Test
  public void doStuffWithArgs_callsDoStuff_withThreeArgs() {
    // When: doing stuff with the string
    mockyMockWrapper.doStuffWithArgs();

    // Then: stuff is done with exactly three things
    verify(mockyMock).doStuff(any(), anyInt(), any()); // Forces you to care about the arg
  }

  @Test
  public void doStuffWithArgs_callsDoStuff_withArgsThatFulfillConditions() {
    // When: doing stuff with the string
    mockyMockWrapper.doStuffWithArgs();

    // Then: stuff is done with exactly three things
    verify(mockyMock)
        .doStuff(eq("Hello World!"), gt(2), not(eq(6.0f)));
  }

  @Test
  public void doStuffWithArgs_callsDoStuff_withArgsThatFulfillOtherConditions() {
    // When: doing stuff with the string
    mockyMockWrapper.doStuffWithArgs();

    // Then: stuff is done with exactly three things
    verify(mockyMock)
        .doStuff(isA(String.class), and(gt(0), lt(20)), isNotNull());
  }
}
