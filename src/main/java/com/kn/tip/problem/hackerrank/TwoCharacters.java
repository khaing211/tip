package com.kn.tip.problem.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/two-characters/
 *
 * Interesting Problem:
 * 1. At 1st glance, it looks like generalized dependency graph problem + optimization
 *   a. char = node, direct edge = s[i] -> s[i+1]
 *   b. remove all nodes  but 2, transitions becomes direct after removal of a node, invalid if there is a self-loop
 *   c. once determine which two nodes to keep, compute string length and keep longest string.
 * 2. Since the string length is max at 1000 and there is finite alphabet (26 characters)
 *   a. We implemented brute force solution which is O(26 * 26 * |s|) = O(|s|)
 */
public class TwoCharacters {
  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int len = in.nextInt();
    final String s = in.next();
    final ArrayList<Character> charSet = IntStream.range(0, s.length()).mapToObj(i -> s.charAt(i))
        .distinct().collect(Collectors.toCollection(ArrayList::new));

    final StringBuilder builder = new StringBuilder(len);
    int maxLength = 0;
    for (int i = 0; i < charSet.size(); i++) {
      for (int j = i + 1; j < charSet.size(); j++) {
        builder.setLength(0);
        for (int k = 0; k < s.length(); k++) {
          final char ch = s.charAt(k);
          if (ch == charSet.get(i) || ch == charSet.get(j)) {
            builder.append(ch);
          }
        }
        final String newS = builder.toString();
        if (validate(newS)) {
          maxLength = Math.max(maxLength, newS.length());
        }
      }
    }

    System.out.println(maxLength);
  }

  private static boolean validate(final String s) {
    if (s.length() < 2) {
      return false;
    }

    for (int k = 1; k < s.length(); k++) {
      if (s.charAt(k - 1) == s.charAt(k)) {
        return false;
      }
    }

    return true;
  }
}
