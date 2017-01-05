package com.kn.tip.problem.ctci;

/**
 * 1st Attempt
 * 1. missing +1 for count array['z'-'a']
 * 2. totalCount = total of character count / not s.length()
 * 3. allowableOdd => lead to the idea of toggle odd/even for particular char count
 */
public class PalindromePermutation {
  public static boolean isPalindromePermutation(final String s) {
    final int[] count = new int['z'-'a' + 1];
    int totalCount = 0;
    for (int i = 0; i < s.length(); i++) {
      final char ch = s.charAt(i);
      if (Character.isLetter(ch)) {
        count[Character.toLowerCase(ch) - 'a']++;
        totalCount++;
      }
    }

    int allowableOdd = totalCount % 2;
    for (int i = 0; i < count.length; i++) {
      allowableOdd -= count[i] % 2;
      if (allowableOdd < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(final String[] args) {
    System.out.println(isPalindromePermutation("Tact Coa"));
  }
}
