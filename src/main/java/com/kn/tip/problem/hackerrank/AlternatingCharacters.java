package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/alternating-characters
 */
public class AlternatingCharacters {
  static int alternatingCharacters(final String s) {
    char nextCh = s.charAt(0) == 'A' ? 'B' : 'A';
    int del = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != nextCh) {
        del++;
      } else {
        nextCh = nextCh == 'A' ? 'B' : 'A';
      }
    }
    return del;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      final String s = in.next();
      final int result = alternatingCharacters(s);
      System.out.println(result);
    }
  }
}
