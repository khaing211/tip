package com.kn.tip.problem.leetcode;

/**
 * You must do this in-place without making a copy of the array. Minimize the total number of
 * operations.
 */
public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    // j maintain index of zero
    int j = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        // if found a zero index
        if (nums[j] == 0) {
          nums[j] = nums[i];
          nums[i] = 0;
          // if i is j+1, then following operation would make i=j where is the next zero
          // if i is not next to j, then j+1 would be still zero
          // because if j+1 is non-zero only if i=j+1
          j++;
        }
      } else {
        // set found zero index
        // if not found already
        if (nums[j] != 0) {
          j = i;
        }
      }
    }
  }
}
