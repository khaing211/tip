package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pylons
 */
public class GoodlandElectricity {
  public static final int INDEX = 0;
  public static final int COVER_DISTANCE = 1;
  public static final int BEST_TOWER_INDEX_SO_FAR = 2;
  public static final int TOWER_TO_TURN_COUNT = 3;
  public static final int PERMISTIC_DISTANCE = 4;

  public static void main(final String[] args) {
    @SuppressWarnings("resource")
    final Scanner scanner = new Scanner(System.in);
    final int n = scanner.nextInt();
    final int k = scanner.nextInt();
    final boolean[] towers = new boolean[n];
    for (int i = 0; i < n; i++) {
      towers[i] = scanner.nextInt() == 1;
    }

    final int[] values = new int[5];
    values[INDEX] = 0;
    values[COVER_DISTANCE] = k - 1;
    values[BEST_TOWER_INDEX_SO_FAR] = -1;
    values[TOWER_TO_TURN_COUNT] = 0;
    values[PERMISTIC_DISTANCE] = k - 1;
    while (values[INDEX] < n) {
      if (towers[values[INDEX]]) {
        values[BEST_TOWER_INDEX_SO_FAR] = values[INDEX];
      }
      // System.err.println(Arrays.toString(values));

      if (values[COVER_DISTANCE] == 0) {
        if (values[BEST_TOWER_INDEX_SO_FAR] != -1) {
          values[TOWER_TO_TURN_COUNT]++;
          // next walk in distance is optimistically calculated
          values[COVER_DISTANCE] = k + values[BEST_TOWER_INDEX_SO_FAR] - values[INDEX] + k - 2;
          // keep permistic distance for last tower
          values[PERMISTIC_DISTANCE] = k + values[BEST_TOWER_INDEX_SO_FAR] - values[INDEX] - 1;
          values[BEST_TOWER_INDEX_SO_FAR] = -1;
        } else {
          System.out.println(-1);
          return;
        }
      } else {
        values[COVER_DISTANCE]--;
        values[PERMISTIC_DISTANCE]--;
      }

      values[INDEX]++;
    }
    // System.err.println(Arrays.toString(values));
    if (values[PERMISTIC_DISTANCE] < 0) {
      if (values[BEST_TOWER_INDEX_SO_FAR] != -1) {
        values[TOWER_TO_TURN_COUNT]++;
      } else {
        System.out.println(-1);
        return;
      }
    }

    System.out.println(values[TOWER_TO_TURN_COUNT]);
  }
}
