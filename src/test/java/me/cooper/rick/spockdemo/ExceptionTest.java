package me.cooper.rick.spockdemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {

  private static final CrapCalc calc = new CrapCalc();

  @Rule
  public final ExpectedException exceptionRule = ExpectedException.none();

  @Test(expected = NullPointerException.class)
  public void getNullFieldsField_throwsNullPointer_crapWay() {
    // When: accessing a null field
    new Encapsulated().nullField.getSuperInterestingFieldAsLongAsMyParentIsNotNull();

    // Then: EXPLOSION?
  }

  @Test
  public void getNullFieldsField_throwsNullPointer_withRule() {
    // Expect: EXPLOSION!
    exceptionRule.expect(NullPointerException.class);

    // When: accessing a null field
    new Encapsulated().nullField.getSuperInterestingFieldAsLongAsMyParentIsNotNull();

    exceptionRule.expectMessage(isEmptyOrNullString());
  }

  @Test
  public void getNullFieldsField_throwsNullPointer_tryCatch() {
    try {
      // When: accessing a null field
      new Encapsulated().nullField.getSuperInterestingFieldAsLongAsMyParentIsNotNull();
      fail("Should have thrown null pointer!");

      // Then: EXPLOSION!
    } catch (final NullPointerException e) {
      assertThat(e.getMessage()).isNull();
    }
  }

  @Test
  public void getNullFieldsField_throwsNullPointer_assertJ() {
    // Expect: EXPLOSION!
    assertThatNullPointerException()

        // When: accessing a null field
        .isThrownBy(() -> new Encapsulated().nullField.getSuperInterestingFieldAsLongAsMyParentIsNotNull())
        .withMessage(null);
  }

  @Test
  public void calc_validArgs_doesNotThrowIllegalArg() {
    try {
      // When: adding 1 and 2
      calc.add(1, 2);
    } catch (final IllegalArgumentException e) {
      // Then: nothing
      fail("Should NOT have thrown null pointer!");
    }
  }

  @org.junit.jupiter.api.Test
  public void getNullFieldsField_throwsNullPointer_jUnit5() {
    final NullPointerException e = assertThrows(
        // Expect: EXPLOSION!
        NullPointerException.class,

        // When: accessing a null field
        () -> new Encapsulated().nullField.getSuperInterestingFieldAsLongAsMyParentIsNotNull()
    );

    assertThat(e.getMessage()).isNull();
  }
}
