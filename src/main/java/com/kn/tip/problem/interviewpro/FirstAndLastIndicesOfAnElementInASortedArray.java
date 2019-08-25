package com.kn.tip.problem.interviewpro;

/**
 * Given a sorted array, A, with possibly duplicated elements, find the indices of the first and
 * last occurrences of a target element, x. Return -1 if the target is not found.
 *
 * Example: Input: A = [1,3,3,5,7,8,9,9,9,15], target = 9 Output: [6,8]
 *
 * Input: A = [100, 150, 150, 153], target = 150 Output: [1,2]
 *
 * Input: A = [1,2,3,4,5,6,10], target = 9 Output: [-1, -1]
 */
public class FirstAndLastIndicesOfAnElementInASortedArray {
  public int[] findElement(final int[] sortedArray, final int target) {
    final int[] result = new int[2];

    result[0] = getLeftPosition(sortedArray, target);
    result[0] = sortedArray[result[0]] == target ? result[0] : -1;
    result[1] = getRightPosition(sortedArray, target);
    result[1] = sortedArray[result[1]] == target ? result[1] : -1;

    return result;
  }

  private int getLeftPosition(final int[] sortedArray, final int target) {
    // since we jump backward, we assume that we didn't match low
    // and low is an exclusive index. Therefore, we have to check low index
    // now
    if (sortedArray[0] == target) {
      return 0;
    }

    int high = sortedArray.length;
    int low = 0;

    while (high - low > 1) {
      final int pivot = computePivot(low, high);

      if (sortedArray[pivot] >= target) {
        high = pivot;
      } else {
        low = pivot;
      }
    }

    return high;
  }

  private int getRightPosition(final int[] sortedArray, final int target) {
    // since the high position is already exclusive by using length()
    // we don't have to check
    int high = sortedArray.length;
    int low = 0;

    while (high - low > 1) {
      final int pivot = computePivot(low, high);

      if (sortedArray[pivot] <= target) {
        low = pivot;
      } else {
        high = pivot;
      }
    }

    return low;
  }

  private int computePivot(final int low, final int high) {
    final int diff = high - low;
    return low + (diff / 2);
  }
}
