package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.interviewbit.com/problems/valid-path/
 */
public class ValidPath {

  public String solve(final int x, final int y, final int N, final int R, final ArrayList<Integer> CX, final ArrayList<Integer> CY) {
    final int[][] grid = new int[x + 1][y + 1];
    final int[] size = new int[] {x, y};
    final int rSquared = R * R;

    for (int i = 0; i < N; i++) {
      final int[] center = new int[] {CX.get(i), CY.get(i)};
      // each circle has their own color visited marker so the algorithm
      // does not mistake for being visited
      floodfillCircle(grid, size, center, rSquared, i + 2);
    }

    // this is not possible
    if (grid[0][0] >= 2 || grid[x][y] >= 2) {
      return "NO";
    }

    floodfillRectangle(grid, size, 1);
    if (grid[0][0] == 1 && grid[x][y] == 1) {
      return "YES";
    }
    return "NO";
  }

  // Flood fill rule is to mark visited before put into the queue
  static void floodfillRectangle(final int[][] grid, final int[] size, final int color) {
    final int[][] delta =
        new int[][] {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    final Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {0, 0});
    // Flood fill rule is to mark visited before put into the queue
    grid[0][0] = color;

    while (!queue.isEmpty()) {
      final int[] point = queue.poll();
      for (int i = 0; i < 8; i++) {
        final int[] newPoint = new int[2];
        newPoint[0] = delta[i][0] + point[0];
        newPoint[1] = delta[i][1] + point[1];
        if (insideRectangle(newPoint, size) && grid[newPoint[0]][newPoint[1]] == 0) {
          // Flood fill rule is to mark visited before put into the queue
          grid[newPoint[0]][newPoint[1]] = color;
          queue.add(newPoint);
        }
      }
    }
  }

  static void floodfillCircle(final int[][] grid, final int[] size, final int[] center, final int rSquared, final int color) {
    final int[][] delta =
        new int[][] {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    final Queue<int[]> queue = new LinkedList<>();
    queue.add(center);
    // Flood fill rule is to mark visited before put into the queue
    grid[center[0]][center[1]] = color;

    while (!queue.isEmpty()) {
      final int[] point = queue.poll();
      for (int i = 0; i < 8; i++) {
        final int[] newPoint = new int[2];
        newPoint[0] = delta[i][0] + point[0];
        newPoint[1] = delta[i][1] + point[1];

        if (insideCircle(center, newPoint, rSquared) && insideRectangle(newPoint, size)
            && grid[newPoint[0]][newPoint[1]] != color) {
          // Flood fill rule is to mark visited before put into the queue
          grid[newPoint[0]][newPoint[1]] = color;
          queue.add(newPoint);
        }
      }
    }
  }

  static boolean insideRectangle(final int[] point, final int[] size) {
    return point[0] >= 0 && point[1] >= 0 && point[0] <= size[0] && point[1] <= size[1];
  }

  static boolean insideCircle(final int[] center, final int[] point, final int rSquared) {
    final int x = center[0] - point[0];
    final int y = center[1] - point[1];
    return (x * x + y * y) <= rSquared;
  }
}
