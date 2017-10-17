package com.kn.tip.problem.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-stones-1
 *
 * Since the maximum constraint is small, precompute everything
 */
public class GameOfStones {
  static boolean verifyWinIfGoesFirst(final Boolean[] winIfGoesFirst, final int i) {
    if (winIfGoesFirst[i] != null) {
      return winIfGoesFirst[i];
    }

    for (final Integer index : Arrays.asList(2, 3, 5)) {
      if (i >= index) {
        verifyWinIfGoesFirst(winIfGoesFirst, i - index);
        if (!winIfGoesFirst[i - index]) {
          winIfGoesFirst[i] = true;
          return winIfGoesFirst[i];
        }
      }
    }

    winIfGoesFirst[i] = false;
    return winIfGoesFirst[i];
  }

  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);

    final Boolean[] winIfGoesFirst = new Boolean[101];
    Arrays.fill(winIfGoesFirst, null);
    // the first cannot win, because he/she cannot remove 0 or 1 stone
    winIfGoesFirst[0] = false;
    winIfGoesFirst[1] = false;
    for (int i = 0; i < 101; i++) {
      verifyWinIfGoesFirst(winIfGoesFirst, i);
    }

    // System.err.println(Arrays.toString(winIfGoesFirst));

    final int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      final int n = scanner.nextInt();
      System.out.println(winIfGoesFirst[n] ? "First" : "Second");
    }
  }
}
