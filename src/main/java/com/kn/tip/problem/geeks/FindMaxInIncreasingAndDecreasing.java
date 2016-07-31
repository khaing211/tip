package com.kn.tip.problem.geeks;

/**
 * Given an array where is there is increasing segment follows by decreasing segments
 * 
 * Find max numbers
 * 
 */
public class FindMaxInIncreasingAndDecreasing {
  // linear scan would be easier
  // can you do in log n?
  // low and high is inclusive index
  public static int findMaxRecursive(int[] array, int low, int high) {
    // only 1 elements
    if (low == high) {
      return array[low];
    }

    // two elements
    if ((high == low + 1) && array[low] >= array[high]) {
      return array[low];
    }

    if ((high == low + 1) && array[low] < array[high]) {
      return array[high];
    }

    int mid = (low + high) / 2;

    // mid is exactly mid
    if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
      return array[mid];
    }

    // you are on decreasing size
    if (array[mid - 1] > array[mid] && array[mid] > array[mid + 1]) {
      return findMaxRecursive(array, low, mid - 1);
    } else {
      // else you are on increasing size
      return findMaxRecursive(array, mid + 1, high);
    }
  }

  public static int findMaxIterative(int[] array) {
    int l = 0;
    int r = array.length - 1;

    while (l + 1 < r) {
      int mid = (l + r) / 2;

      if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
        return array[mid];
      }

      if (array[mid - 1] > array[mid] && array[mid] > array[mid + 1]) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    if (l == r) {
      return array[l];
    } else if (array[l] > array[r]) {
      return array[l];
    } else {
      return array[r];
    }
  }

  public static void main(String[] args) {
    System.out.println(1 == findMaxRecursive(new int[] {0, 1}, 0, 1));
    System.out.println(2 == findMaxRecursive(new int[] {2, 1}, 0, 1));
    System.out.println(2 == findMaxRecursive(new int[] {0, 1, 2, 1}, 0, 3));
    System.out.println(2 == findMaxRecursive(new int[] {0, 2, 1, 0}, 0, 3));

    System.out.println(1 == findMaxIterative(new int[] {0, 1}));
    System.out.println(2 == findMaxIterative(new int[] {2, 1}));
    System.out.println(2 == findMaxIterative(new int[] {0, 1, 2, 1}));
    System.out.println(2 == findMaxIterative(new int[] {0, 2, 1, 0}));
  }

}
