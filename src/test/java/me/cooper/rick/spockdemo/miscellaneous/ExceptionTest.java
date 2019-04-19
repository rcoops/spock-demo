package me.cooper.rick.spockdemo.miscellaneous;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static me.cooper.rick.spockdemo.Fixtures.calc;
import static me.cooper.rick.spockdemo.Fixtures.encapsulated;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("all")
public class ExceptionTest {

  @Rule
  public final ExpectedException exceptionRule = ExpectedException.none();

  @Test(expected = NullPointerException.class)
  public void getNullFieldsField_throwsNullPointer_crapWay() {
    // when: accessing a null field
    encapsulated.nullField.getSuperInterestingFieldAsLongAsMyParentIsNotNull();

    // then: EXPLOSION! ...?
  }

  @Test
  public void getNullFieldsField_throwsNullPointer_withRule() {
    // expect: EXPLOSION! with detail
    exceptionRule.expect(NullPointerException.class);

    // when: accessing a null field
    encapsulated.nullField.getSuperInterestingFieldAsLongAsMyParentIsNotNull();

    exceptionRule.expectMessage(isEmptyOrNullString());
  }

  @Test
  public void getNullFieldsField_throwsNullPointer_tryCatch() {
    try {
      // when: accessing a null field
      encapsulated.nullField.getSuperInterestingFieldAsLongAsMyParentIsNotNull();
      fail("Should have thrown null pointer!");

      // then: EXPLOSION! with detail
    } catch (final NullPointerException e) {
      assertThat(e.getMessage()).isNull();
    }
  }

  @Test
  public void getNullFieldsField_throwsNullPointer_assertJ() {
    // expect: EXPLOSION! with detail
    assertThatNullPointerException()

        // when: accessing a null field
        .isThrownBy(() -> encapsulated.nullField.getSuperInterestingFieldAsLongAsMyParentIsNotNull())
        .withMessage(null);
  }

  @Test
  public void calc_validArgs_doesNotThrowIllegalArg() {
    try {
      // when: adding 1 and 2
      calc.add(1, 2);
    } catch (final IllegalArgumentException e) {
      // then: nothing
      fail("Should NOT have thrown null pointer!");
    }
  }

  @org.junit.jupiter.api.Test
  public void getNullFieldsField_throwsNullPointer_jUnit5() {
    final NullPointerException e = assertThrows(
        // expect: EXPLOSION!
        NullPointerException.class,

        // when: accessing a null field
        () -> encapsulated.nullField.getSuperInterestingFieldAsLongAsMyParentIsNotNull()
    );

    assertThat(e.getMessage()).isNull();
  }
}
