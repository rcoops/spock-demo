package me.cooper.rick.spockdemo.interaction;

import static org.mockito.Mockito.inOrder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import me.cooper.rick.spockdemo.MockWrapper;
import me.cooper.rick.spockdemo.Mockable;

@RunWith(MockitoJUnitRunner.class)
public class VerifyOrderTest {

  @Mock
  private Mockable mockyMock;

  private static MockWrapper mockyMockWrapper;

  @Before
  public void beforeEach() {
    mockyMockWrapper = new MockWrapper(mockyMock);
  }

  @Test
  public void testOrder() {
    // Given: We've set up our order checker
    final InOrder inOrder = inOrder(mockyMock);

    // When: Doing stuff in order
    mockyMockWrapper.doStuffInOrder();

    // Then: Calls one
    inOrder.verify(mockyMock).one();
    // Then: Calls two
    inOrder.verify(mockyMock).two();
    // Then: Calls three
    inOrder.verify(mockyMock).three();
  }
}
