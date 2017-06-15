package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

// A string  contains many patterns of the form 1(0+)1 where represents any non-empty consecutive sequence of 's. The patterns are allowed to overlap.
public class PatternCount {
  static int patternCount(final String s) {
    boolean hasSeenOne = false;
    boolean hasSeenZeroAfterOne = false;
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      final char ch = s.charAt(i);
      if (ch == '1') {
        if (hasSeenOne && hasSeenZeroAfterOne) {
          count++;
          hasSeenZeroAfterOne = false;
        }
        hasSeenOne = true;
      } else if (ch == '0') {
        if (hasSeenOne) {
          hasSeenZeroAfterOne = true;
        }
      } else {
        hasSeenOne = false;
        hasSeenZeroAfterOne = false;
      }

    }
    return count;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      final String s = in.next();
      final int result = patternCount(s);
      System.out.println(result);
    }
  }
}
