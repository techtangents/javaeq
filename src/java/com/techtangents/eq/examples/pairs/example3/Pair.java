package com.techtangents.eq.examples.pairs.example3;

import com.techtangents.eq.InstanceEq;

public class Pair<A, B> implements InstanceEq<Pair<A, B>>{
  public final A a;
  public final B b;

  private Pair(final A a, final B b) {
    this.a = a;
    this.b = b;
  }

  public static <A, B> Pair<A, B> pair(final A a, final B b) {
    return new Pair<A, B>(a, b);
  }

  @Override
  public boolean eq(final Pair<A, B> other) {
    return a.equals(other.a) && b.equals(other.b);
  }
}
