package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/separate-the-numbers
 */
public class SeparateTheNumbers {
  public static String isBeautiful(final String s) {
    long first;
    for (int i = 1; i < s.length() / 2 + 1; i++) {
      // Using Long instead of Integer
      long n = Long.parseLong(s.substring(0, i));
      first = n;
      int j = i;
      boolean match = true;
      while (j < s.length()) {
        n++;
        final String strN = Long.toString(n);
        if (!s.startsWith(strN, j)) {
          match = false;
          break;
        }
        j += strN.length();
      }

      if (match) {
        return "YES " + first;
      }

      if (i == 1 && s.startsWith("0")) {
        return "NO";
      }
    }

    return "NO";
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      final String s = in.next();
      System.out.println(isBeautiful(s));
    }
  }
}
