package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sock-merchant
 */
public class SockMerchant {
  static int sockMerchant(final int n, final int[] ar) {
    final int[] color = new int[101];
    for (int i = 0; i < n; i++) {
      color[ar[i]]++;
    }
    int count = 0;
    for (int i = 0; i < color.length; i++) {
      count += color[i] / 2;
    }
    return count;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int[] ar = new int[n];
    for (int ar_i = 0; ar_i < n; ar_i++) {
      ar[ar_i] = in.nextInt();
    }
    final int result = sockMerchant(n, ar);
    System.out.println(result);
  }
}
