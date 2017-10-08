package com.kn.tip.problem.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class EletronicsShope {
  static int getMoneySpent(final Integer[] keyboards, final Integer[] drives, final int s) {
    // descending order [3,2,1....]
    Arrays.sort(keyboards, Collections.reverseOrder());
    // ascending order [1,2,3...]
    Arrays.sort(drives);

    int j = 0;
    int max = -1;
    for (int i = 0; i < keyboards.length; i++) {
      for (; j < drives.length; j++) {
        if (keyboards[i] + drives[j] > s) {
          // no point increasing drives if keyboards is too expensive
          break;
        }
        max = Math.max(max, keyboards[i] + drives[j]);
      }
    }
    return max;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int s = in.nextInt();
    final int n = in.nextInt();
    final int m = in.nextInt();
    final Integer[] keyboards = new Integer[n];
    for (int keyboards_i = 0; keyboards_i < n; keyboards_i++) {
      keyboards[keyboards_i] = in.nextInt();
    }
    final Integer[] drives = new Integer[m];
    for (int drives_i = 0; drives_i < m; drives_i++) {
      drives[drives_i] = in.nextInt();
    }
    // The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't
    // purchase both items
    final int moneySpent = getMoneySpent(keyboards, drives, s);
    System.out.println(moneySpent);
  }
}
