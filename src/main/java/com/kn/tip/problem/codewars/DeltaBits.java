package com.kn.tip.problem.codewars;

public class DeltaBits {
  public static int convertBits(final int a, final int b) {
    return Integer.bitCount(a ^ b);
  }
}
