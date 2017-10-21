package com.kn.tip.problem.hackerrank;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/queries-with-fixed-length/problem
 *
 * Using queue for Sliding Window classic problem
 * Queue stores the index, not the value of the array
 * Queue#first() is always the maximum of the sliding window
 * Queue#rest() stores the next local maximum(s) of the sliding window if any
 *
 * Considering a decreasing array with window size of 3
 * [5 ,4, 3, 2, 1, 8, 7, 6, 5]
 */
public class QueriesWithFixedLength {
  static int minOfMax(final int[] array, final int d) {
    final int n = array.length;
    final Deque<Integer> queue = new LinkedList<>();
    // find max of the first d elements
    // and keep all elements after the max of the first d elements.
    for (int i = 0; i < d; i++) {
      final int element = array[i];
      while (!queue.isEmpty() && array[queue.peekLast()] < element) {
        // all the smaller element comes before max element does not matter
        queue.removeLast();
      }
      queue.addLast(i);
    }

    int ret = Integer.MAX_VALUE;
    for (int i = d; i < n; i++) {
      ret = Math.min(ret, array[queue.peekFirst()]);

      while (!queue.isEmpty() && queue.peekFirst() <= i - d) {
        // outside of sliding window
        queue.removeFirst();
      }

      final int element = array[i];
      while (!queue.isEmpty() && array[queue.peekLast()] < element) {
        // all the smaller element comes before max element does not matter
        queue.removeLast();
      }
      queue.addLast(i);
    }

    // the last sliding window
    ret = Math.min(ret, array[queue.peekFirst()]);

    return ret;
  }

  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int n = scanner.nextInt();
    final int q = scanner.nextInt();
    final int[] array = new int[n];

    for (int i = 0; i < n; i++) {
      array[i] = scanner.nextInt();
    }
    for (int i = 0; i < q; i++) {
      final int d = scanner.nextInt();
      System.out.println(minOfMax(array, d));
    }
  }
}
