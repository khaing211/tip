package com.kn.tip.problem.interviewpro;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Can you find a solution in linear time?
 */
public class LongestSubstringWithoutRepeatingCharacters {
  public String find(final String s) {
    final Set<Character> seenBefore = new HashSet<>();
    String bestSoFar = "";
    int start = 0;

    for (int i = 0; i < s.length(); i++) {
      if (seenBefore.contains(s.charAt(i))) {
        final int len = i - start;
        if (len > bestSoFar.length()) {
          bestSoFar = s.substring(start, i);
        }
        seenBefore.clear();
        start = i;
      }

      seenBefore.add(s.charAt(i));
    }

    final int len = s.length() - start;
    if (len > bestSoFar.length()) {
      bestSoFar = s.substring(start);
    }

    return bestSoFar;
  }
}
