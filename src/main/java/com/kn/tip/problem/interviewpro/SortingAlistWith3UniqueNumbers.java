package com.kn.tip.problem.interviewpro;

/**
 * Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list in O(n) time.
 *
 * Example 1: Input: [3, 3, 2, 1, 3, 2, 1] Output: [1, 1, 2, 2, 3, 3, 3]
 *
 * Challenge: Try sorting the list using constant space.
 */
public class SortingAlistWith3UniqueNumbers{
  public int[] sort(final int[] array) {
    // The hint is the challenge again.
    // maximum time: O(2n)
    // trick is to maintain following two values.
    int currentFindee = 1;
    int lastNotMatchIndex = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == currentFindee) {
        swap(array, i, lastNotMatchIndex);
        lastNotMatchIndex++;
      }
      // reset
      if (i == array.length - 1 && currentFindee != 3) {
        // -1 in account for the adjustment of increment in the for loop
        i = lastNotMatchIndex - 1;
        currentFindee++;
      }
    }

    // making test easier
    return array;
  }

  public void swap(final int[] array, final int a, final int b) {
    final int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}
