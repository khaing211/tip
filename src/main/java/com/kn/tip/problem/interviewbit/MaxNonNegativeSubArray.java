package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/max-non-negative-subarray/
 *
 * Edge cases:
 * 1. Value sum to integer overflow
 * 2. Output result testing (comparison logic should be put in its own method)
 * 3. last element checking
 */
public class MaxNonNegativeSubArray {
  public static ArrayList<Integer> maxset(final ArrayList<Integer> a) {
    final int n = a.size();
    final ArrayList<Integer> result = new ArrayList<>(n);
    long maxSum = 0;
    long currentSum = 0;
    final ArrayList<Integer> currentResult = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      if (a.get(i) < 0) {
        maxSum = compareAndSwap(maxSum, result, currentSum, currentResult);
        currentSum = 0;
        currentResult.clear();
      } else {
        currentSum += a.get(i);
        currentResult.add(a.get(i));
      }
    }

    compareAndSwap(maxSum, result, currentSum, currentResult);

    return result;
  }

  /**
   * @return new maxSum if any
   */
  static long compareAndSwap(final long maxSum, final ArrayList<Integer> maxResult,
      final long candidateSum, final ArrayList<Integer> candidateResult) {

    if (candidateSum > maxSum
        || (candidateSum == maxSum && candidateResult.size() > maxResult.size())) {
      maxResult.clear();
      maxResult.addAll(candidateResult);
      return candidateSum;
    }
    return maxSum;
  }
}
