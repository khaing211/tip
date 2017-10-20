package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation
 */
public class InPlaceArrayRotation {
  static int[] leftRotation(final int[] a, final int d) {
    // inplace rotation
    final int n = a.length;
    // assume a.length > 0
    final boolean half = n / 2 == d;
    if (half) {
      for (int i = 0; i < n / 2; i++) {
        swap(a, i, n / 2 + i);
      }
    } else {
      // The following algorithm serves by putting
      // the nextIndex/nextValue into a temporary variables. This make O(1) space.
      // Visualization: there is a rabbit jump by 'd' distance for every 'step'
      // by n steps, the rabbit should visit all the square
      // with the exception of 'd' = n/2. At the exception
      // the rabbit would run in 'circle'.
      int nextIndex = 0;
      int nextValue = a[nextIndex];
      for (int i = 0; i < n; i++) {
        // note: this variable name serves as clarification
        final int currentIndex = nextIndex;
        final int currentValue = nextValue;
        nextIndex = shiftLeft(currentIndex, d, n);
        nextValue = a[nextIndex];
        a[nextIndex] = currentValue;
      }
    }
    return a;
  }

  static void swap(final int[] a, final int i, final int j) {
    final int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  static int shiftLeft(final int i, final int d, final int n) {
    return (i - d + n) % n;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int d = in.nextInt();
    final int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    final int[] result = leftRotation(a, d);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
    }
    System.out.println("");


    in.close();
  }
}
