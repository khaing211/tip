package com.kn.tip.problem.codewars;

import java.util.Arrays;

public class AreTheyTheSame {

  public static boolean comp(final int[] a, final int[] b) {
    if (a == null || b == null || a.length != b.length) {
      return false;
    }
    for (int i = 0; i < a.length; i++) {
      a[i] = a[i] * a[i];
    }
    Arrays.sort(a);
    Arrays.sort(b);
    return Arrays.equals(a, b);
  }
}