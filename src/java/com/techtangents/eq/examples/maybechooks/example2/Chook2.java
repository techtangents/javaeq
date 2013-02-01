package com.techtangents.eq.examples.maybechooks.example2;

import com.techtangents.eq.InstanceEq;

// let's try InstanceEq
public class Chook2 implements InstanceEq<Chook2> {
  public final String name;

  private Chook2(final String name) {
    this.name = name;
  }

  public static Chook2 chook2(final String name) {
    return new Chook2(name);
  }

  // Not bad... but has problems for Maybe2

  @Override
  public boolean eq(final Chook2 o) {
    return name.equals(o.name);
  }
}
