package com.techtangents.eq;

public class Eqs {

  public static Eq<String> stringEq = javaLangObjectEq();

  public static Eq<Integer> intEq = javaLangObjectEq();

  public static <T> Eq<T> javaLangObjectEq() {
    return new Eq<T>() {
      @Override
      public boolean eq(final T a, final T b) {
        return a.equals(b);
      }
    };
  }

  public static <O, P> Eq<O> getterEq(final Eq<P> pEq, final F<O, P> getter) {
    return new Eq<O>() {
      @Override
      public boolean eq(final O a, final O b) {
        return pEq.eq(getter.apply(a), getter.apply(b));
      }
    };
  }

  public static <A> Eq<A> and(final Eq<A> eqA, final Eq<A> eqB) {
    return new Eq<A>() {
      @Override
      public boolean eq(final A a, final A b) {
        return eqA.eq(a, b) && eqB.eq(a, b);
      }
    };
  }

  public static <A> Eq<A> or(final Eq<A> eqA, final Eq<A> eqB) {
    return new Eq<A>() {
      @Override
      public boolean eq(final A a, final A b) {
        return eqA.eq(a, b) || eqB.eq(a, b);
      }
    };
  }
}
