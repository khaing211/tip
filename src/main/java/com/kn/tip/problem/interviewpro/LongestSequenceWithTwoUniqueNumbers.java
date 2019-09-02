package com.kn.tip.problem.interviewpro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 *
 * Given a sequence of numbers, find the longest sequence that contains only 2 unique numbers.
 *
 * Example:
 *
 * Input: [1, 3, 5, 3, 1, 3, 1, 5]
 * Output: 4
 *
 */
public class LongestSequenceWithTwoUniqueNumbers {
  public int size(final List<Integer> list) {
    final Set<Integer> seems = new HashSet<>();

    final ListIterator<Integer> start = list.listIterator();
    int bestSoFar = 0;
    int size = 0;
    while (start.hasNext()) {
      final Integer val = start.next();
      if (!seems.contains(val)) {
        seems.add(val);
        if (seems.size() > 2) {
          // update bestSoFar
          bestSoFar = Math.max(bestSoFar, size);

          // rewind
          start.previous();
          final Integer val2 = start.previous();
          seems.retainAll(Arrays.asList(val, val2));
          while (start.hasPrevious() && seems.contains(start.previous())) {
            // do nothing
          }
          start.next();
          // offset by -1, because we are not recounting any element
          size = -1;
        }
      }

      size++;
    }

    return Math.max(bestSoFar, size);
  }
}
