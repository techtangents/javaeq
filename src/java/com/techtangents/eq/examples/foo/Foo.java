package com.techtangents.eq.examples.foo;

/* In java.lang:
class Object {
  boolean equals(Object o);
}
*/

public class Foo /* extends Object */ {

  public final String s;

  public Foo(final String s) {
    this.s = s;
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof Foo && s.equals(((Foo)o).s);
  }

  public static void main(String[] _) {
    Foo x = new Foo("x");
    Foo y = new Foo("y");
    boolean b = x.equals(y);

    boolean c = new Foo("x").equals(72);

    new Foo("x").equals(new com.sun.java.swing.plaf.nimbus.InternalFrameInternalFrameTitlePaneInternalFrameTitlePaneMaximizeButtonPainter(null, 3));
  }
}

