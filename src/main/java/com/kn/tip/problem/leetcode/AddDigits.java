package com.kn.tip.problem.leetcode;

public class AddDigits {

  public int addDigits(int num) {
    if (num >= 10) {
      return addDigits(num % 10 + addDigits(num / 10));
    } else {
      return num;
    }
  }
}
