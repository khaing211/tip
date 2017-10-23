package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * https://www.interviewbit.com/problems/smallest-sequence-with-given-primes/
 *
 * Using PriorityQueue to do bread-first generation
 * *
 */
public class SmallestSequenceWithGivenNumbers {
  public ArrayList<Integer> solve(final int A, final int B, final int C, final int D) {
    final int[] primes = new int[] {A, B, C};
    final ArrayList<Integer> result = new ArrayList<>();
    final PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < 3; i++) {
      queue.add(primes[i]);
    }

    while (result.size() < D) {
      final int val = queue.poll();
      // Dealing with duplicate
      // Also the cause of extra size
      while (!queue.isEmpty() && queue.peek() == val) {
        queue.poll();
      }
      result.add(val);
      for (int i = 0; i < 3; i++) {
        queue.add(val * primes[i]);
      }
    }

    return result;
  }
}
