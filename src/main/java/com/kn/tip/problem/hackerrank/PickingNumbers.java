package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/picking-numbers
 */
public class PickingNumbers {
  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int[] a = new int[n];
    final int[] bucket = new int[101];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
      bucket[a[a_i]]++;
    }
    // pick a pair of two consecutive numbers that has maximum count
    int count = 0;
    for (int i = 1; i < 101; i++) {
      count = Math.max(count, bucket[i] + bucket[i - 1]);
    }
    System.out.println(count);
  }
}
