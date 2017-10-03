package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records
 */
public class BreakingTheRecords {
  static int[] getRecord(final int[] s) {
    final int[] ret = new int[2];
    final int[] soFar = new int[] {s[0], s[0]};
    final int BEST = 0;
    final int WORST = 1;
    for (int i = 1; i < s.length; i++) {
      if (s[i] > soFar[BEST]) {
        ret[BEST]++;
        soFar[BEST] = s[i];
      } else if (s[i] < soFar[WORST]) {
        ret[WORST]++;
        soFar[WORST] = s[i];
      }
    }
    return ret;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int[] s = new int[n];
    for (int s_i = 0; s_i < n; s_i++) {
      s[s_i] = in.nextInt();
    }
    final int[] result = getRecord(s);
    String separator = "";
    final String delimiter = " ";
    for (final Integer val : result) {
      System.out.print(separator + val);
      separator = delimiter;
    }
    System.out.println("");
  }
}
