package com.techtangents.eq.examples.pairs.example1;

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
}
