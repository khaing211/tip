package com.kn.tip.problem.leetcode;

import java.util.HashSet;

public class ContainDuplicate {
  /**
   * Using HashSet make it O(n) instead of sort solution
   */
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      // check in case of long of Array
      if (set.contains(num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }
}
