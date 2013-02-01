package com.techtangents.eq.examples.maybechooks.example2;

import com.techtangents.eq.F;
import com.techtangents.eq.InstanceEq;
import com.techtangents.eq.Konst;
import com.techtangents.eq.Thunk;

import static com.techtangents.eq.Konst.konstT;
import static com.techtangents.eq.examples.maybechooks.example2.Chook2.chook2;

public abstract class Maybe2<T> implements InstanceEq<Maybe2<T>> {

  public abstract <B> B fold(final Thunk<B> noneT, final F<T, B> someT);

  public static <T> Maybe2<T> some(final T t) {
    return new Maybe2<T>() {
      @Override
      public <B> B fold(final Thunk<B> _, final F<T, B> someT) {
        return someT.apply(t);
      }
    };
  }

  public static <T> Maybe2<T> none() {
    return new Maybe2<T>() {
      @Override
      public <B> B fold(final Thunk<B> noneT, final F<T, B> _) {
        return noneT.get();
      }
    };
  }

  @Override
  public boolean eq(final Maybe2<T> other) {
    return fold(new Thunk<Boolean>() {
        @Override
        public Boolean get() {
          return other.fold(konstT(true), Konst.<T>konstF(false));
        }
      }, new F<T, Boolean>() {
        @Override
        public Boolean apply(final T a) {
          return other.fold(konstT(false), new F<T, Boolean>() {
            @Override
            public Boolean apply(final T b) {

              // HEY, it's that bloody java.lang.Object.equals
              // I want to use that eq I defined on Chook2
              return a.equals(b);
            }
          });
        }
      }
    );
  }


  static {
    final Maybe2<Chook2> mc = some(chook2("Mr Bawk Bagawk"));
    final Maybe2<String> x = some("hello");
  }

}
