package com.techtangents.eq.examples.example3;

import com.techtangents.eq.Eq;

import static com.techtangents.eq.Eqs.stringEq;

public class Chook3a {
  public final String name;

  private Chook3a(final String name) {
    this.name = name;
  }

  public static Chook3a chook3(final String name) {
    return new Chook3a(name);
  }

  public static Eq<Chook3a> eq = new Eq<Chook3a>() {
    @Override
    public boolean eq(final Chook3a a, final Chook3a b) {
      // Let's use a first-class eq to compare the strings
      return stringEq.eq(a.name, b.name);
    }
  };
}
