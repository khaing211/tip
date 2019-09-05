package com.kn.tip.problem.interviewpro;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a
 * contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the
 * minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
  public static int size(final int[] array, final int sum) {
    if (array.length == 0) {
      return 0;
    }

    if (array.length == 1 || array[0] >= sum) {
      return array[0] >= sum ? 1 : 0;
    }

    int currentSum = array[0];
    int bestSoFar = array.length+1;
    int i = 0;
    int j = 1;
    while (j < array.length) {
      currentSum += array[j];
      if (currentSum >= sum) {
        int newSum = currentSum;
        while (i < j && newSum - array[i] >= sum) {
          newSum -= array[i];
          i++;
        }
        currentSum = newSum;
        bestSoFar = Math.min(bestSoFar, j - i + 1);

        // early return?
        if (bestSoFar == 1) {
          return 1;
        }
      }

      j++;
    }

    return currentSum >= sum ? bestSoFar : 0;
  }
}
