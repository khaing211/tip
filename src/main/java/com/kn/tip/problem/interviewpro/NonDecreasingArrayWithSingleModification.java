package com.kn.tip.problem.interviewpro;

/**
 * You are given an array of integers in an arbitrary order. Return whether or not it is possible to
 * make the array non-decreasing by modifying at most 1 element to any value.
 *
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 *
 * Example:
 *
 * [13, 4, 7] should return true, since we can modify 13 to any value 4 or less, to make it
 * non-decreasing.
 *
 * [13, 4, 1] however, should return false, since there is no way to modify just one element to make
 * the array non-decreasing.
 */
public class NonDecreasingArrayWithSingleModification {
  public boolean isAbleToMakeSingleModification(final int[] array) {
    if (array.length <= 2) {
      return true;
    }

    int count = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i-1] > array[i]) {
        count++;
      }
    }

    return count <= 1;
  }
}
