package me.cooper.rick.spockdemo;

public class Encapsulated {

  private static final String definitelyPrivateField = "ha! you'll never see me cos: encapsulation right?";

  private final int myField = 1;

  public final ObjectWrapper nullField = null;

  public int getMyField() {
    return myField + 1;
  }
}
