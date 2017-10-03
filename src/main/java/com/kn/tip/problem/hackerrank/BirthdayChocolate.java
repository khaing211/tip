package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-birthday-bar
 */
public class BirthdayChocolate {
  static int solve(final int n, final int[] s, final int d, final int m) {
    if (n < m) {
      return 0;
    }
    int c = 0;
    int sum = 0;
    for (int i = 0; i < m && i < n; i++) {
      sum += s[i];
    }
    if (sum == d) {
      c++;
    }
    for (int i = m; i < n; i++) {
      sum += s[i] - s[i - m];
      if (sum == d) {
        c++;
      }
    }
    return c;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int[] s = new int[n];
    for (int s_i = 0; s_i < n; s_i++) {
      s[s_i] = in.nextInt();
    }
    final int d = in.nextInt();
    final int m = in.nextInt();
    final int result = solve(n, s, d, m);
    System.out.println(result);
  }
}
