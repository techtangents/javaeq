package com.techtangents.eq.examples.pairs.example5;

import com.techtangents.eq.Eq;

import static com.techtangents.eq.Eqs.stringEq;

public class Person {
  public final String name;
  private Person(final String name) {
    this.name = name;
  }

  public static Person person(final String name) {
    return new Person(name);
  }

  public static Eq<Person> personEq = new Eq<Person>() {
    @Override
    public boolean eq(final Person a, final Person b) {
      return stringEq.eq(a.name, b.name);
    }
  };
}
