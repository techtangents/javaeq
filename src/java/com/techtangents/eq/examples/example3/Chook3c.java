package com.techtangents.eq.examples.example3;

import com.techtangents.eq.Eq;
import com.techtangents.eq.F;

import static com.techtangents.eq.Eqs.and;
import static com.techtangents.eq.Eqs.getterEq;
import static com.techtangents.eq.Eqs.stringEq;

public class Chook3c {
  public final String name;
  public final String nickName;

  private Chook3c(final String name, final String nickName) {
    this.name = name;
    this.nickName = nickName;
  }

  public static Chook3c chook3(final String name, final String nickName) {
    return new Chook3c(name, nickName);
  }

  public static F<Chook3c, String> getName = new F<Chook3c, String>() {
    @Override
    public String apply(final Chook3c chook3b) {
      return chook3b.name;
    }
  };

  public static F<Chook3c, String> getNickName = new F<Chook3c, String>() {
    @Override
    public String apply(final Chook3c chook3b) {
      return chook3b.nickName;
    }
  };

  // Let's compose Eqs!
  // Two Chook3c's are equal if their names and nicknames are equal
  public static Eq<Chook3c> eq = and(getterEq(stringEq, getName), getterEq(stringEq, getNickName));
}
