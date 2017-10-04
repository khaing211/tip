package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/richie-rich
 */
public class RichieRich {
  static String richieRich(final String s, final int n, final int k) {
    int diff = 0;
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        diff++;
      }
    }
    if (diff > k) {
      return "-1";
    }
    // extra are number of mutations one can do after doing necessary mutations to make a palindrome
    int extra = k - diff;
    final StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length() / 2; i++) {
      // The two cases are where we can spend the extra to make the number as big as possible
      // If the both chars are same, that means it takes 2 mutations in extra bucket, because it was not necessary to change this to make a palindrome
      if (extra >= 2
          && s.charAt(i) == s.charAt(s.length() - 1 - i)
          && s.charAt(i) != '9') {
        builder.append('9');
        extra -= 2;
      } else if (extra >= 1
          && s.charAt(i) != s.charAt(s.length() - 1 - i)
          && s.charAt(i) != '9'
          && s.charAt(s.length() - 1 - i) != '9') {
        // If the both chars are different and both are not '9', you need to spend only one extra, because it is accounted that you spend another mutation
        // to make a palindrome
        builder.append('9');
        extra -= 1;
      } else if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        // The basic mutation usecase is to modify the string to be a palindrome.
        // No need to spend any extra, because any mutation in usecase is accounted
        // to be smart, mutation should take the larger digit of 2 digits.
        final int front = Integer.valueOf(String.valueOf(s.charAt(i)));
        final int back = Integer.valueOf(String.valueOf(s.charAt(s.length() - 1 - i)));
        final int max = Math.max(front, back);
        builder.append(max);
      } else {
        // Base case, same chars, no mutation.
        builder.append(s.charAt(i));
      }
    }

    final String backString = new StringBuilder(builder).reverse().toString();
    // check for the middle character.
    if (s.length() % 2 == 1) {
      if (extra >= 1) {
        // There is some extra, we should use it
        builder.append('9');
      } else {
        builder.append(s.charAt(s.length() / 2));
      }

    }
    builder.append(backString);
    return builder.toString();
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int k = in.nextInt();
    final String s = in.next();
    final String result = richieRich(s, n, k);
    System.out.println(result);
  }
}
