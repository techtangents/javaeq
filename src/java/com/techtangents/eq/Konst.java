package com.techtangents.eq;

public class Konst {
  public Konst() {
  }

  public static Thunk<Boolean> konstT(final boolean b) {
    return new Thunk<Boolean>() {
      @Override
      public Boolean get() {
        return b; // none == none  
      }
    };
  }

  public static <T> F<T, Boolean> konstF(final boolean b) {
    return new F<T, Boolean>() {
      @Override
      public Boolean apply(final T _) {
        return b;
      }
    };
  }
}