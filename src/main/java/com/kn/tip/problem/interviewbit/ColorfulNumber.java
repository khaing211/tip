package com.kn.tip.problem.interviewbit;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.interviewbit.com/problems/colorful-number/
 *
 * Using Set<> to check for duplication
 */
public class ColorfulNumber {
  public int colorful(final int a) {
    final String v = Integer.toString(a);
    final int n = v.length();
    final int[] values = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = v.charAt(i) - '0';
    }
    final Set<Integer> products = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int product = 1;
      for (int j = i; j < n; j++) {
        product *= values[j];
        if (products.contains(product)) {
          return 0;
        } else {
          products.add(product);
        }
      }
    }
    return 1;
  }
}
