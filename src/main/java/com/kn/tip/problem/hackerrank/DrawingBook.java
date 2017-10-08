package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

public class DrawingBook {
  static int solve(final int n, final int p) {
    // n/2 = total pages
    // p/2 = offset
    return Math.min(n / 2 - p / 2, p / 2);
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int p = in.nextInt();
    final int result = solve(n, p);
    System.out.println(result);
  }
}
