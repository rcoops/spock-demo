package me.cooper.rick.spockdemo.data.driven;

import org.junit.Rule;
import org.junit.Test;

import me.cooper.rick.spockdemo.rule.IgnoreRestRule;

public class IgnoreTest {

  @Rule
  public IgnoreRestRule test = new IgnoreRestRule("testTrue6");

  @Test
  public void testTrue1() {
    assert false;
  }

  @Test
  public void testTrue2() {
    assert false;
  }

  @Test
  public void testTrue3() {
    assert false;
  }

  @Test
  public void testTrue4() {
    assert true;
  }

  @Test
  public void testTrue5() {
    assert true;
  }

  @Test
  public void testTrue6() {
    assert true;
  }

  @Test
  public void testTrue7() {
    assert true;
  }

  @Test
  public void testTrue8() {
    assert false;
  }

  @Test
  public void testTrue9() {
    assert true;
  }
}
