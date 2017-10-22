package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/add-one-to-number/
 */
public class AddOneToNumber {
  public static ArrayList<Integer> plusOne(final ArrayList<Integer> a) {
    while (!a.isEmpty() && a.get(0) == 0) {
      a.remove(0);
    }

    // Zero means '1'
    if (a.isEmpty()) {
      a.add(1);
      return a;
    }

    final int n = a.size();
    // the first carry has 1, but we add one
    int carry = 1;
    for (int i = n - 1; i >= 0; i--) {
      final int e = a.get(i) + carry;
      // compute next carry
      carry = e / 10;
      // mod 10 is to get the remainder
      a.set(i, e % 10);
    }

    if (carry != 0) {
      a.add(0, carry);
    }

    return a;
  }
}
