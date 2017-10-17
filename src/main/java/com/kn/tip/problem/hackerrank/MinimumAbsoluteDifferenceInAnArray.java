package com.kn.tip.problem.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array
 */
public class MinimumAbsoluteDifferenceInAnArray {
  static int minimumAbsoluteDifference(final int n, final int[] arr) {
    // sort will guarantee 2 adj elements to have min abs difference
    Arrays.sort(arr);
    int diff = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      diff = Math.min(diff, Math.abs(arr[i] - arr[i - 1]));
    }
    return diff;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int[] arr = new int[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
    }
    final int result = minimumAbsoluteDifference(n, arr);
    System.out.println(result);
    in.close();
  }
}
