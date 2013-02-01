package com.techtangents.eq.examples.pairs.example4;

import com.techtangents.eq.InstanceEq;

public class Person implements InstanceEq<Person> {
  public final String name;

  private Person(final String name) {
    this.name = name;
  }

  public static Person person(final String name) {
    return new Person(name);
  }

  @Override
  public boolean eq(final Person other) {
    return name.equals(other.name);
  }
}
