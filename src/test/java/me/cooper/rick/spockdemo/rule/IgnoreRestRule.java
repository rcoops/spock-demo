package me.cooper.rick.spockdemo.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class IgnoreRestRule implements TestRule {

  private String methodNameNotToIgnore;

  public IgnoreRestRule(String methodNameNotToIgnore) {
    this.methodNameNotToIgnore = methodNameNotToIgnore;
  }

  @Override
  public Statement apply(final Statement base, final Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        if (methodNameNotToIgnore.equals(description.getMethodName())) {
          base.evaluate();
        }
      }
    };
  }
}
