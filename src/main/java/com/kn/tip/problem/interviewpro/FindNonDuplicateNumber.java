package com.kn.tip.problem.interviewpro;

/**
 * Given a list of numbers, where every number shows up twice except for one number, find that one
 * number.
 *
 * Example: Input: [4, 3, 2, 4, 1, 3, 2] Output: 1
 *
 * Challenge: Find a way to do this using O(1) memory.
 */
public class FindNonDuplicateNumber {
  public int find(final int[] array) {
    // Note:
    // the hint is the challenge finding the number in O(1).
    // Using magic xor
    int target = 0;
    for (int i = 0; i < array.length; i++) {
      target ^= array[i];
    }
    return target;
  }
}
