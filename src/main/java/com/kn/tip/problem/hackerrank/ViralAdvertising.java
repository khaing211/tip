package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/strange-advertising
 */
public class ViralAdvertising {
  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int n = scanner.nextInt();
    int s = 0;
    int p = 5;
    for (int i = 0; i < n; i++) {
      final int t = p / 2;
      s += t;
      p = t * 3;
    }
    System.out.println(s);
  }
}
