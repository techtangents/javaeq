package com.techtangents.eq.examples.maybechooks.example3;

import com.techtangents.eq.Eq;
import com.techtangents.eq.F;

import static com.techtangents.eq.Eqs.getterEq;
import static com.techtangents.eq.Eqs.stringEq;

public class Chook3b {
  public final String name;

  private Chook3b(final String name) {
    this.name = name;
  }

  public static Chook3b chook3(final String name) {
    return new Chook3b(name);
  }

  public static F<Chook3b, String> getName = new F<Chook3b, String>() {
    @Override
    public String apply(final Chook3b chook3b) {
      return chook3b.name;
    }
  };

  // Given an Eq<B> and F<A, B>, we can make an Eq<A>
  // i.e. if we can get the name of a Chook and equate them, then we can equate the chook
  public static Eq<Chook3b> eq = getterEq(stringEq, getName);
}
