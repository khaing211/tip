package com.kn.tip.problem.leetcode;

import java.util.HashMap;

/**
 * You can solve this by recursion, but with simple logic you can see that whenever you hold any
 * multiple of 4 stones, then you cannot win.
 * 
 * Your opponent also try to reduce to multiple of 4 till 4 stones left.
 */
public class NimGame {

  public static boolean canWinNim(int n) {
    // checking the last 2 bit i.e. dividable by 4
    return (n & 0b11) != 0;
  }
}


