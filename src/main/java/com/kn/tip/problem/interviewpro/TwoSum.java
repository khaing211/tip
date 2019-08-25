package com.kn.tip.problem.interviewpro;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a list of numbers, and a target number k. Return whether or not there are two
 * numbers in the list that add up to k.
 *
 * Example: Given [4, 7, 1 , -3, 2] and k = 5, return true since 4 + 1 = 5.
 *
 * Try to do it in a single pass of the list.
 */
public class TwoSum {
  public boolean isTwoSum(final int[] array, final int k) {
    // using a Set for a watch list for the other numbers
    final Set<Integer> watchList = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      // note to self: order matters
      if (watchList.contains(array[i])) {
        return true;
      }

      watchList.add(k - array[i]);
    }
    return false;
  }
}
