package com.kn.tip.problem.leetcode;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i] += carry;
      carry = digits[i] / 10;
      digits[i] = digits[i] % 10;
    }

    if (carry == 0) {
      return digits;
    }


    int[] copy = new int[digits.length + 1];
    System.arraycopy(digits, 0, copy, 1, digits.length);
    copy[0] = carry;

    return copy;
  }
}
