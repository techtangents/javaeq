package com.techtangents.eq.examples.strinq;

import com.techtangents.eq.InstanceEq;

public class Strinq implements InstanceEq<Strinq> {
  public final String s;

  private Strinq(final String s) {
    this.s = s;
  }

  public static Strinq strinq(final String s) {
    return new Strinq(s);
  }

  @Override
  public boolean eq(final Strinq other) {
    return s.equals(other.s);
  }

  public static void main(final String[] args) {
    strinq("x").eq(strinq("y"));
  }
}


