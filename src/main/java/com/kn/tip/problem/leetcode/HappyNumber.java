package com.kn.tip.problem.leetcode;

import java.util.HashSet;

public class HappyNumber {
  public boolean isHappy(int n) {
    HashSet<Integer> hasSeemNumbers = new HashSet<Integer>();

    while (n != 1) {
      if (hasSeemNumbers.contains(n)) {
        return false;
      }

      hasSeemNumbers.add(n);
      n = squareDigits(n);
    }

    return true;

  }

  public int squareDigits(int n) {
    int sum = 0;
    while (n != 0) {
      int digit = n % 10;
      sum += digit * digit;
      n /= 10;
    }

    return sum;
  }
}
