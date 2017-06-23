package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-pairs/problem
 */
public class BeautifulPairs {
  @SuppressWarnings("resource")
  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int n = scanner.nextInt();
    final int[] a = new int[1001];
    final int[] b = new int[1001];
    for (int i = 0; i < n; i++) {
      a[scanner.nextInt()]++;
    }
    for (int i = 0; i < n; i++) {
      b[scanner.nextInt()]++;
    }

    int count = 0;
    for (int i = 1; i < 1001; i++) {
      count += Math.min(a[i], b[i]);
    }
    // You "must" change a number in B. If you have perfect match, then you always have one less.
    // Otherwise, you always have one more.
    System.out.println(n == count ? count - 1 : count + 1);
  }
}
