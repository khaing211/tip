package com.kn.tip.problem.hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string
 */
public class SherlockAndValidString {
  static String isValid(final String s) {
    final Map<Character, Integer> bucket = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      bucket.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
    }

    // find unique count
    final Set<Integer> values = new HashSet<>(bucket.values());
    if (values.size() == 1) {
      // there is no need to delete, because count is same.
      return "YES";
    }
    System.err.println(values);
    // we could delete a char under some condition
    if (values.size() == 2) {
      final Iterator<Integer> iterator = values.iterator();
      final int first = iterator.next();
      final int second = iterator.next();
      final int min = Math.min(first, second);
      final int max = Math.max(first, second);
      // if there is a char with one count
      if (min == 1) {
        final long count =
            bucket.entrySet().stream().filter(entry -> entry.getValue() == min).count();
        if (count == 1) {
          return "YES";
        }
      }
      // if there is a char in longer sequence if only one difference between 2 counts.
      if (max - min == 1) {
        final long count =
            bucket.entrySet().stream().filter(entry -> entry.getValue() == max).count();
        if (count == 1) {
          return "YES";
        }
      }
    }

    return "NO";
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final String s = in.next();
    final String result = isValid(s);
    System.out.println(result);
  }
}
