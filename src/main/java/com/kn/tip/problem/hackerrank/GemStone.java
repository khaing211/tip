package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/gem-stones
 */
public class GemStone {
  static int gemstones(final String[] arr) {
    final int len = 'z' - 'a' + 1;
    final boolean[][] counts = new boolean[arr.length][len];
    for (int i = 0; i < arr.length; i++) {
      final String s = arr[i];
      for (int j = 0; j < s.length(); j++) {
        counts[i][s.charAt(j) - 'a'] = true;
      }
    }

    int count = 0;
    for (int j = 0; j < len; j++) {
      int c = 0;
      for (int i = 0; i < arr.length; i++) {
        c += counts[i][j] ? 1 : 0;
      }
      count += c == arr.length ? 1 : 0;
    }
    return count;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final String[] arr = new String[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.next();
    }
    final int result = gemstones(arr);
    System.out.println(result);
  }
}
