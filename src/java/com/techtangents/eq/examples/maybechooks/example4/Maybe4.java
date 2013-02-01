package com.techtangents.eq.examples.maybechooks.example4;

import com.techtangents.eq.*;

import static com.techtangents.eq.Konst.konstT;
import static com.techtangents.eq.examples.maybechooks.example4.Chook4.chook4;

// Maybe4 can use any type as its type parameter - doesn't have to be equatable any more
public abstract class Maybe4<T> {

  private final Konst konst = new Konst();

  public abstract <B> B fold(final Thunk<B> noneT, final F<T, B> someT);

  public static <T> Maybe4<T> some(final T t) {
    return new Maybe4<T>() {
      @Override
      public <B> B fold(final Thunk<B> _, final F<T, B> someT) {
        return someT.apply(t);
      }
    };
  }

  public static <T> Maybe4<T> none() {
    return new Maybe4<T>() {
      @Override
      public <B> B fold(final Thunk<B> noneT, final F<T, B> _) {
        return noneT.get();
      }
    };
  }

  // A Maybe4<T> is equatable if T is equatable...
  // ... so, if we have an Eq<T>, we can construct an Eq<Maybe4<T>>

  public static <T> Eq<Maybe4<T>> eq(final Eq<T> teq) {
    return new Eq<Maybe4<T>>() {
      @Override
      public boolean eq(final Maybe4<T> a, final Maybe4<T> b) {
        return a.fold(new Thunk<Boolean>() {
            @Override
            public Boolean get() {
              return b.fold(konstT(true), Konst.<T>konstF(false));
            }
          }, new F<T, Boolean>() {
            @Override
            public Boolean apply(final T ta) {
              return b.fold(konstT(false), new F<T, Boolean>() {
                @Override
                public Boolean apply(final T tb) {
                  // This is more like it!
                  // Use the Eq<T> to compare the T's
                  return teq.eq(ta, tb);
                }
              });
            }
          }
        );
      }
    };
  }

  static {
    final Maybe4<Chook4> a = some(chook4("Mr Bawk Bagawk", "chookie"));
    final Maybe4<Chook4> b = some(chook4("Mr Bawk Bagawk", "chookie2"));
    final Eq<Maybe4<Chook4>> eq = Maybe4.eq(Chook4.eq);
    final boolean result = eq.eq(a, b);

    final Maybe4<String> x = some("hello");
    final Maybe4<String> y = some("hello");
    final Eq<Maybe4<String>> eq1 = Maybe4.eq(Eqs.stringEq);
    final boolean result2 = eq1.eq(x, y);
  }
}
