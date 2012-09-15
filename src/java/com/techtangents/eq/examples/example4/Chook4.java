package com.techtangents.eq.examples.example4;

import com.techtangents.eq.Eq;
import com.techtangents.eq.F;

import static com.techtangents.eq.Eqs.*;

public class Chook4 {
  public final String name;
  public final String nickName;

  private Chook4(final String name, final String nickName) {
    this.name = name;
    this.nickName = nickName;
  }

  public static Chook4 chook4(final String name, final String nickName) {
    return new Chook4(name, nickName);
  }

  public static F<Chook4, String> getName = new F<Chook4, String>() {
    @Override
    public String apply(final Chook4 chook3b) {
      return chook3b.name;
    }
  };

  public static F<Chook4, String> getNickName = new F<Chook4, String>() {
    @Override
    public String apply(final Chook4 chook3b) {
      return chook3b.nickName;
    }
  };

  public static Eq<Chook4> eq = and(getterEq(stringEq, getName), getterEq(stringEq, getNickName));
}
