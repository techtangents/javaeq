package com.techtangents.eq.examples.maybechooks.example3;

import com.techtangents.eq.Eq;

// let's try Eq
public class Chook3 {
  public final String name;

  private Chook3(final String name) {
    this.name = name;
  }

  public static Chook3 chook3(final String name) {
    return new Chook3(name);
  }

  public static Eq<Chook3> eq = new Eq<Chook3>() {
    @Override
    public boolean eq(final Chook3 a, final Chook3 b) {
      return a.name.equals(b.name);
    }
  };
}
