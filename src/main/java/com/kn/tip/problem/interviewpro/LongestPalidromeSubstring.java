package com.kn.tip.problem.interviewpro;

import java.util.Optional;

/**
 * A palindrome is a sequence of characters that reads the same backwards and forwards. Given a
 * string, s, find the longest palindromic substring in s.
 *
 * Example: Input: "banana" Output: "anana" Input: "million" Output: "illi"
 */
public class LongestPalidromeSubstring {
  public String find(final String s) {
    // Question: s does not come from a finite space (i.e., a english dictionary)

    // palindrome is about the middle pivot.
    // The longest substring palindrome must be a palindrome that has a pivot
    // that is closer to the middle pivot of s.
    // brute force would be O(n^2) starting with middle pivot and test to see if it is
    // palindrome, then continue to go left and right while keep bestSoFar with alternative
    // of odd-out palindrome (aba) or even palindrome (acca)

    // The other attempts in spare time here
    // is to keep track of potential pivot and
    // run a final test of potential pivot to find the longest palindrome
    // not sure if it is less than O(n^2).
    // actual case scenario is still O(n^2) example: identical characters aaaaaaaa

    // So here is the brute force solution
    String bestSoFar = "";
    for (int i = s.length() / 2; i >= bestSoFar.length(); i--) {
      // This can refactored by using List and Stream#reduce
      final String bestSoFar0 = bestSoFar;
      final String bestSoFar1 =
          getOddPalindrome(s, i).filter(it -> it.length() > bestSoFar0.length()).orElse(bestSoFar0);
      final String bestSoFar2 = getEvenLeftPalindrome(s, i)
          .filter(it -> it.length() > bestSoFar1.length()).orElse(bestSoFar1);
      bestSoFar = getEvenRightPalindrome(s, i).filter(it -> it.length() > bestSoFar2.length())
          .orElse(bestSoFar2);
    }
    return bestSoFar;
  }

  private Optional<String> getOddPalindrome(final String s, final int pivot) {
    if (pivot == 0) {
      return Optional.of(s.substring(0, 1));
    }

    final int len = Math.min(s.length() - pivot, pivot - 1);
    for (int i = 1; i <= len; i++) {
      if (s.charAt(pivot + i) != s.charAt(pivot - i)) {
        return Optional.of(s.substring(pivot - i, pivot + i + 1));
      }
    }
    return Optional.of(s.substring(pivot - len, pivot + len + 1));
  }

  private Optional<String> getEvenLeftPalindrome(final String s, final int pivot) {
    if (pivot == 0 || s.charAt(pivot) != s.charAt(pivot - 1)) {
      return Optional.empty();
    }

    final int len = Math.min(s.length() - pivot, pivot - 1);
    for (int i = 1; i <= len; i++) {
      if (s.charAt(pivot + i) != s.charAt(pivot - 1 - i)) {
        return Optional.of(s.substring(pivot - i, pivot + i));
      }
    }

    return Optional.of(s.substring(pivot - len - 1, pivot + len + 1));
  }

  // "baab", pivot = 1
  private Optional<String> getEvenRightPalindrome(final String s, final int pivot) {
    if (pivot == s.length() - 1 || s.charAt(pivot) != s.charAt(pivot + 1)) {
      return Optional.empty();
    }
    final int len = Math.min(s.length() - pivot - 2, pivot);
    for (int i = 1; i <= len; i++) {
      if (s.charAt(pivot + 1 + i) != s.charAt(pivot - i)) {
        return Optional.of(s.substring(pivot - i + 1, pivot + 1 + i));
      }
    }

    return Optional.of(s.substring(pivot - len + 1, pivot + 1 + len));
  }

}
