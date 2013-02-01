package com.techtangents.eq.examples.maybechooks.example2;

import com.techtangents.eq.F;
import com.techtangents.eq.InstanceEq;
import com.techtangents.eq.Konst;
import com.techtangents.eq.Thunk;

import static com.techtangents.eq.Konst.konstT;
import static com.techtangents.eq.examples.maybechooks.example2.Chook2.chook2;

// What if I require the type argument to be equatable?
public abstract class Maybe2a<T extends InstanceEq<T>> implements InstanceEq<Maybe2a<T>> {

  private final Konst konst = new Konst();

  public abstract <B> B fold(final Thunk<B> noneT, final F<T, B> someT);

  public static <T extends InstanceEq<T>> Maybe2a<T> some(final T t) {
    return new Maybe2a<T>() {
      @Override
      public <B> B fold(final Thunk<B> _, final F<T, B> someT) {
        return someT.apply(t);
      }
    };
  }

  public static <T extends InstanceEq<T>> Maybe2a<T> none() {
    return new Maybe2a<T>() {
      @Override
      public <B> B fold(final Thunk<B> noneT, final F<T, B> _) {
        return noneT.get();
      }
    };
  }

  @Override
  public boolean eq(final Maybe2a<T> other) {
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

            // HEY! There's my InstanceEq.eq!
            return a.eq(b);
          }
        });
      }
    });
  }

  static {
    final Maybe2a<Chook2> mc = some(chook2("Mr Bawk Bagawk"));

    // This doesn't work, because String isn't equatable. Yuck.
    //final Maybe2a<String> x = some("hello");
  }
}
