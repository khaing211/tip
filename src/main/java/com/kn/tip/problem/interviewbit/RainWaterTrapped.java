package com.kn.tip.problem.interviewbit;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Given [0,1,0,2,1,0,1,3,2,1,2,1],
 * return 6
 *
 * Approach: image of filling out water and those water turns into 'sand'
 * at each altitude
 */
public class RainWaterTrapped {
  static int rainWaterTrapped(final int[] elevation) {
    // maintain strictly descending height, hill index
    final Stack<Integer> decreasingElevationIndex = new Stack<>();
    int rainWaterTrapped = 0;

    for (int i = 0; i < elevation.length; i++) {
      final int height = elevation[i];
      // when the hill is no longer strictly decreasing
      if (!decreasingElevationIndex.isEmpty() && elevation[decreasingElevationIndex.peek()] <= height) {
        // The last hill's height is serve as the 1st valley height
        int valleyHeight = elevation[decreasingElevationIndex.peek()];
        // remove that hill from height computation
        decreasingElevationIndex.pop();
        while(!decreasingElevationIndex.isEmpty()) {
          // basin height is the lesser of height of two ends of the valley
          final int basinHeight = Math.min(height, elevation[decreasingElevationIndex.peek()]);
          // delta height is the difference between valley height and basin height
          final int deltaHeight = basinHeight - valleyHeight;
          // water volum = width between two hills * height of basin height
          final int additionalWaterTrapped = (i - decreasingElevationIndex.peek() - 1) * deltaHeight;
          rainWaterTrapped += additionalWaterTrapped;
          // getting the new valley height for a possible next iteration
          valleyHeight = elevation[decreasingElevationIndex.peek()];
          // current height is still taller than last hill height
          // until computation
          if (elevation[decreasingElevationIndex.peek()] <= height) {
            decreasingElevationIndex.pop();
          } else {
            // otherwise, you break, because the last hill a local maximum
            break;
          }
        }
      }
      decreasingElevationIndex.add(i);
    }

    return rainWaterTrapped;
  }

  public static void main(final String[] args) {
    System.out.println(rainWaterTrapped(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    // Local max vs global max valley
    System.out.println(rainWaterTrapped(new int[] {0,1,0,5,1,0,1,2,1,2,6}));
    System.out.println(rainWaterTrapped(new int[] {2,1,0,5,1,0,1,2,1,2,6}));
    // Right Triangle valley
    System.out.println(rainWaterTrapped(new int[] {0,4,3,2,1,0,0,5}));
  }
}
