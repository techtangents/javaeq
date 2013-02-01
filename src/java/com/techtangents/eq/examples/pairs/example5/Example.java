package com.techtangents.eq.examples.pairs.example5;

import static com.techtangents.eq.Eqs.intEq;
import static com.techtangents.eq.Eqs.stringEq;
import static com.techtangents.eq.examples.Util.println;
import static com.techtangents.eq.examples.pairs.example5.Pair.pair;
import static com.techtangents.eq.examples.pairs.example5.Pair.pairEq;
import static com.techtangents.eq.examples.pairs.example5.Person.person;
import static com.techtangents.eq.examples.pairs.example5.Person.personEq;

public class Example {
  public static void main(final String[] _) {
    final Pair<String, Integer> p1 = pair("a", 3);
    final Pair<String, Integer> p2 = pair("a", 3);
    final boolean eq1 = pairEq(stringEq, intEq).eq(p1, p2);
    println("eq1 = " + eq1);

    final Pair<Person, Integer> mary = pair(person("mary"), 33);
    final Pair<Person, Integer> fred = pair(person("fred"), 87);
    final boolean eq2 = pairEq(personEq, intEq).eq(mary, fred);
    println("eq2 = " + eq2);
  }
}