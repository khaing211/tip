package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/kangaroo/problem
 */
public class Kangaroo {
  // This is an interesting problem
  // unlike the car-chase problem, the kangaroo is operating in a discrete world.
  static String kangaroo(final int x1, final int v1, final int x2, final int v2) {
    // This check is to avoid zero-division when the speed is same
    // and/or the position is the same.
    if (v1 == v2) {
      return x1 == x2 ? "YES" : "NO";
    }
    if (x1 == x2) {
      return v1 == v2 ? "YES" : "NO";
    }
    final int diffX = x1 - x2;
    final int signX = diffX / Math.abs(diffX);
    final int diffV = v1 - v2;
    final int signV = diffV / Math.abs(diffV);
    // compute sign, two sign should be different i.e. either slower kangaroo is ahead or faster kangaroo is behind.
    // modulo of zero to check the discrete steps.
    return signX != signV && diffX % diffV == 0 ? "YES" : "NO";
}

public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int x1 = in.nextInt();
    final int v1 = in.nextInt();
    final int x2 = in.nextInt();
    final int v2 = in.nextInt();
    final String result = kangaroo(x1, v1, x2, v2);
    System.out.println(result);
}
}
