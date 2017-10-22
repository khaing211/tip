package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 *
 * Diagonal movement allows shorter distance
 */
public class MinStepInInfiniteGrid {
  // X and Y co-ordinates of the points in order.
  // Each point is represented by (X.get(i), Y.get(i))
  public int coverPoints(final ArrayList<Integer> X, final ArrayList<Integer> Y) {
    if (X == null || Y == null) {
      return 0;
    }
    if (X.size() <= 1 || Y.size() <= 1) {
      return 0;
    }
    if (X.size() != Y.size()) {
      return 0;
    }

    final int n = X.size();
    // since the output is 'int', the problem does not expect Integer overflow
    int step = 0;
    for (int i = 1; i < n; i++) {
      final int distanceX = Math.abs(X.get(i) - X.get(i - 1));
      final int distanceY = Math.abs(Y.get(i) - Y.get(i - 1));
      final int max = Math.max(distanceX, distanceY);
      step += max;
    }
    return step;
  }
}
