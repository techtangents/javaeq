package com.techtangents.eq.examples.strinq;

import com.techtangents.eq.InstanceEq;

public class EqAdapter<T> implements InstanceEq<EqAdapter<T>> {
  public final T t;

  private EqAdapter(final T t) {
    this.t = t;
  }

  public static <T> EqAdapter<T> eqAdapter(final T t) {
    return new EqAdapter<T>(t);
  }

  @Override
  public boolean eq(final EqAdapter<T> other) {
    return t.equals(other.t);
  }

  public static void main(final String[] args) {
    eqAdapter("x").eq(eqAdapter("y"));
    eqAdapter(34).eq(eqAdapter(34));
  }
}


