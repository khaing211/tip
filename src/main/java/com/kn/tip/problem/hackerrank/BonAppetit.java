package com.kn.tip.problem.hackerrank;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BonAppetit {
  static String bonAppetit(final int n, final int k, final int b, final int[] ar) {
    // the problem didn't state that there is the sum would not be divisible by 2.
    final int bActual = IntStream.range(0, n).filter(i -> i != k).map(i -> ar[i]).sum() / 2;
    if (bActual == b) {
      return "Bon Appetit";
    } else {
      return Integer.toString(b - bActual);
    }

  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int k = in.nextInt();
    final int[] ar = new int[n];
    for (int ar_i = 0; ar_i < n; ar_i++) {
      ar[ar_i] = in.nextInt();
    }
    final int b = in.nextInt();
    final String result = bonAppetit(n, k, b, ar);
    System.out.println(result);
  }
}
