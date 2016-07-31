package com.kn.tip.problem.cc;

import com.kn.tip.problem.SubsetSum;

/**
 * Given an array of integer sum up to X
 * 
 * Is there a subset such that sum up to X/2 given that X is even?
 * 
 * The integer is non-negative.
 */
public class HalfSum {
  public static boolean isHalfSum(int[] array) {
    int sum = sum(array);
    if (sum % 2 == 1) {
      return false;
    }
    
    int halfSum = sum / 2;
    
    return SubsetSum.isSubsetDP(array, halfSum);
  }
  
  public static int sum(int[] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    return sum;
  }
}
