package com.kn.tip.problem.codewars;

import java.util.Arrays;

public class PascalsTriangle {
  public static int[][] pascal(final int depth) {
    if (depth <= 0) {
      return null;
    }
    final int[][] triangle = new int[depth][];
    for (int d = 1; d <= depth; d++) {
      triangle[d-1] = new int[d];
      for (int i = 1; i <= d; i++) {
        if (i == 1 || i == d) {
          triangle[d-1][i-1] = 1;
        } else {
          triangle[d-1][i-1] = triangle[d-2][i-1] + triangle[d-2][i-2];
        }
      }
    }

    return triangle;
  }

  public static void main(final String[] args) {
    print(pascal(9));
  }

  private static void print(final int[][] triangle) {
    for (int i = 0; i < triangle.length; i++) {
      System.out.println(Arrays.toString(triangle[i]));
    }
  }
}
