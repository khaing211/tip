package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-loops
 */
public class JavaLoops {
  public static void main(final String[] argh) {
    final Scanner in = new Scanner(System.in);
    final int t = in.nextInt();
    for (int i = 0; i < t; i++) {
      final long a = in.nextInt();
      final long b = in.nextInt();
      final long n = in.nextInt();
      long s = a + b;
      long e = 1;
      System.out.print(String.format("%d ", s));
      for (int j = 1; j < n; j++) {
        e *= 2;
        s += e * b;
        System.out.print(String.format("%d ", s));
      }
      System.out.println();
    }
    in.close();
  }
}
