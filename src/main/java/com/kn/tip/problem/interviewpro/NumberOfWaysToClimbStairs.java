package com.kn.tip.problem.interviewpro;

/**
 *
 * You are given a positive integer N which represents the number of steps in a staircase. You can
 * either climb 1 or 2 steps at a time. Write a function that returns the number of unique ways to
 * climb the stairs.
 */
public class NumberOfWaysToClimbStairs {
  public long compute(final long steps) {
    if (steps < 1) {
      return 0;
    }
    if (steps == 1) {
      return 1;
    }
    if (steps == 2) {
      return 2;
    }
    // Very similar to fib
    // switch 2,1 because 2%2 == 0
    final long[] result = new long[]{2, 1};
    for (long i = 3; i <= steps; i++) {
      result[(int)(i % 2)] = result[0] + result[1];
    }

    return result[(int)(steps % 2)];
  }
}
