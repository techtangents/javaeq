package com.techtangents.eq.examples.pairs.example5;

import com.techtangents.eq.Eq;

public class Pair<A, B> {
  public final A a;
  public final B b;

  private Pair(final A a, final B b) {
    this.a = a;
    this.b = b;
  }

  public static <A, B> Pair<A, B> pair(final A a, final B b) {
    return new Pair<A, B>(a, b);
  }

  public static <A, B> Eq<Pair<A, B>> pairEq(final Eq<A> eqa, final Eq<B> eqb) {
    return new Eq<Pair<A, B>>() {
      @Override
      public boolean eq(final Pair<A, B> p1, final Pair<A, B> p2) {
        return eqa.eq(p1.a, p2.a) && eqb.eq(p1.b, p2.b);
      }
    };
  }
}