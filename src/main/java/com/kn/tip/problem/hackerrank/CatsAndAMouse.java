package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * ps://www.hackerrank.com/challenges/cats-and-a-mouse
 */
public class CatsAndAMouse {
  private static String whoWin(final int x, final int y, final int z) {
    final int diffX = Math.abs(x - z);
    final int diffY = Math.abs(y - z);
    return diffX == diffY ? "Mouse C" : diffX > diffY ? "Cat B" : "Cat A";
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      final int x = in.nextInt();
      final int y = in.nextInt();
      final int z = in.nextInt();
      System.out.println(whoWin(x, y, z));
    }
  }
}
