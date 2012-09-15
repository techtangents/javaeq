package com.techtangents.eq.examples.example1;

public class Chook1 {
  public final String name;

  // you're all using private constructors, right?
  private Chook1(final String name) {
    this.name = name;
  }

  public static Chook1 chook1(final String name) {
    return new Chook1(name);
  }

  // This is what I usually do for java.lang.Object.equals overrides...

  @Override
  public boolean equals(final Object o) {
    // type-casing and casting - and here I was thinking Java was statically-typed!
    return o instanceof Chook1 && eq((Chook1)o);
  }

  // hey, this signature's looking slightly more sensible
  private boolean eq(final Chook1 o) {
    return name.equals(o.name);
  }
}
