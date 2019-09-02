package com.kn.tip.problem.interviewpro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a list of numbers, find if there exists a pythagorean triplet in that list. A pythagorean
 * triplet is 3 variables a, b, c where a^2 + b^2 = c^2
 *
 * Input: [3, 5, 12, 5, 13]
 * Output: True
 */
public class FindPythagoreanTriplets {
  public boolean find(final List<Integer> array) {
    if (array.size() < 3) {
      return false;
    }

    final List<Integer> squared = array.stream()
        .map(i -> i * i)
        .sorted()
        .collect(Collectors.toList());

    final Set<Integer> lookupValues = new HashSet<>();
    for (int i = 1; i < squared.size(); i++) {
      final Integer a = squared.get(i);
      if (lookupValues.contains(a)) {
        return true;
      }
      final Integer b = squared.get(i-1);
      final Integer sum = a + b;
      lookupValues.add(sum);
    }

    return false;
  }
}
