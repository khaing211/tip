package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 *
 * https://www.hackerrank.com/challenges/magic-square-forming
 * Per's Kevinagin and Lachy on forum which is great
 *
 * 1. The middle cell has to be 5. With unique constraint of numeric value i.e. [1-9],
 * so each row/col/diagonal must be sum up to 15. With process of elimination, every other pair
 * of number sum up to 10 so 5 must be in the middle cell.
 *
 * 2. From #1, there are 4 pair, [1,9], [2,8], [3,7], [4,6]
 *
 * 3. With little testing, only [2,8] and [4,6] pairs can be put in the corner
 *
 * 4. With mirror/reflection and rotation, you can generate 8 magic 3x3 squares
 *
 * The easiest way is to compute is to go through which square is closest match
 */
public class MagicSquareForming {
  private static final int[][][] PRECOMPUTE_SQUARES = new int[][][] {
      {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
      {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
      {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
      {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
      {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
      {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
      {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
      {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
  };

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int[][] s = new int[3][3];
    for(int s_i=0; s_i < 3; s_i++){
        for(int s_j=0; s_j < 3; s_j++){
            s[s_i][s_j] = in.nextInt();
        }
    }

    int cost = 100;
    for (int i = 0; i < 8; i++) {
      int tmpCost = 0;
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          tmpCost += Math.abs(PRECOMPUTE_SQUARES[i][j][k] - s[j][k]);
        }
      }
      cost = Math.min(cost, tmpCost);
    }
    System.out.println(cost);
  }
}
