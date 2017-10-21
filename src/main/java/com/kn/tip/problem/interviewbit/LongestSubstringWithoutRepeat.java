package com.kn.tip.problem.interviewbit;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/longest-substring-without-repeat/
 * Given a string,
 * find the length of the longest substring without repeating characters.
 *
 * Example:
 * The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeat {
  public int lengthOfLongestSubstring(final String a) {
    if (a == null) {
      return 0;
    }

    if (a.length() == 1) {
      return 1;
    }

    final Map<Character, Integer> charToIndex = new HashMap<>();
    charToIndex.put(a.charAt(0), 0);
    int startIndex = 0;
    int bestLengthSoFar = 0;

    for (int i = 1; i < a.length(); i++) {
      final char ch = a.charAt(i);
      if (charToIndex.containsKey(ch)) {
        bestLengthSoFar = Math.max(charToIndex.size(), bestLengthSoFar);
        // set the startIndex to be after the 1st repeated ch
        final int endIndex = charToIndex.get(ch) + 1;
        while (startIndex < endIndex) {
          charToIndex.remove(a.charAt(startIndex));
          startIndex++;
        }
      }
      charToIndex.put(ch, i);
    }

    // Check the last substring (ends with last character)
    return Math.max(bestLengthSoFar, charToIndex.size());
  }
}
