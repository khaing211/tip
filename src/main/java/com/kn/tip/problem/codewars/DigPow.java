package com.kn.tip.problem.codewars;

public class DigPow {
  public static long digPow(final int n, final int p) {
    long s = 0;
    final String k = Long.toString(n);
    for (int i = 0; i < k.length(); i++) {
      s += (long) Math.pow(k.charAt(i) - '0', p+i);
    }

    return s % n == 0 ? s / n : -1;
  }
}
