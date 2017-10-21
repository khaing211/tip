package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/2-sum/
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not
 * zero-based. Put both these numbers in order in an array and return the array from your function
 * Looking at the function signature will make things clearer ). Note that, if no pair exists,
 * return empty list.
 *
 * If multiple solutions exist, output the one where index2 is minimum. If there are multiple
 * solutions with the minimum index2, choose the one with minimum index1 out of them.
 */
public class TwoSum {
  /**
   * Since this problem is index-sensitive, Array cannot be sorted (the index information will be lost)
   */
  public ArrayList<Integer> twoSum(final List<Integer> a, final int b) {
    final ArrayList<Integer> result = new ArrayList<>();
    final Map<Integer, Integer> remainderToSmallestIndex = new HashMap<>();
    final int n = a.size();
    // going left to right ensuring getting the minimum index
    for (int i = 0; i < n; i++) {
      final int candidate = a.get(i);
      if (remainderToSmallestIndex.containsKey(candidate)) {
        // 1-based index
        result.add(remainderToSmallestIndex.get(candidate) + 1);
        result.add(i + 1);
        return result;
      }
      final int remainder = b - candidate;
      // if the remainder is not there already (i.e. there is no duplicate of the element yet)
      // then put the remainder, index mapping
      if (!remainderToSmallestIndex.containsKey(remainder)) {
        remainderToSmallestIndex.put(remainder, i);
      }
    }
    return result;
  }
}
