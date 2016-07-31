package com.kn.tip.problem.ctci;

import java.util.Arrays;

// Given an array of integer
// Find n,m indices such that by sorting sub array[n..m] the entire array is sorted increasing order
public class SubSort {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(subsort(new int[] {1, 2, 3, 4, 11, 2, 5, 7, 13})));
  }

  public static int[] subsort(int[] array) {
    int[] ret = new int[2];
    if (array == null || array.length <= 1)
      return ret;

    int leftEnd = findLeftEnd(array);
    int rightStart = findRightStart(array);

    // middle part is unsorted
    // including both leftEnd, and rightStart
    int minMiddle = findMin(array, leftEnd, rightStart);
    int maxMiddle = findMax(array, leftEnd, rightStart);

    ret[0] = findLeftLessThan(array, minMiddle);
    ret[1] = findRightGreaterThan(array, maxMiddle);
    return ret;
  }

  public static int findLeftLessThan(int[] array, int minMiddle) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] >= minMiddle) {
        return i;
      }
    }
    return array.length - 1;
  }

  public static int findRightGreaterThan(int[] array, int maxMiddle) {
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] <= maxMiddle) {
        return i;
      }
    }
    return 0;
  }

  public static int findMin(int[] array, int start, int end) {
    int ret = array[start];
    for (int i = start; i <= end; i++) {
      ret = Math.min(array[i], ret);
    }
    return ret;
  }

  public static int findMax(int[] array, int start, int end) {
    int ret = array[start];
    for (int i = start; i <= end; i++) {
      ret = Math.max(array[i], ret);
    }
    return ret;
  }

  // find first index i from the left such that such that
  // array[i] > array[i+1]
  public static int findLeftEnd(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1]) {
        return i;
      }
    }
    return array.length - 1;
  }

  // find first index i from the right such that array[i-1] > array[i]
  public static int findRightStart(int[] array) {
    for (int i = array.length - 1; i > 0; i--) {
      if (array[i - 1] > array[i]) {
        return i;
      }
    }
    return 0;
  }
}
