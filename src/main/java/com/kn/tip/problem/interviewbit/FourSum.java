package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/4-sum/
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *
 * Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
 * @author developer
 *
 */
public class FourSum {
  public ArrayList<ArrayList<Integer>> fourSum(final ArrayList<Integer> a, final int b) {
    return new ArrayList<>();
  }

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
