package com.kn.tip.problem.hackerrank;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation
 */
public class InPlaceArrayRotation {
  // The else block can be removed/merged is there to demonstrate the evolution of logic
  static int[] leftRotation(final int[] a, final int d) {
    // assume a.length > 0
    // inplace rotation
    final int n = a.length;
    final int gcd = gcd(n, d);
    final boolean nonOneGcd = gcd != 1;
    if (nonOneGcd) {
      final int nblock = n / gcd;
      for (int j = 0; j < gcd; j++) {
        int nextIndex = j;
        int nextValue = a[j];
        for (int i = 0; i < nblock; i++) {
          final int currentIndex = nextIndex;
          final int currentValue = nextValue;
          nextIndex = shiftLeft(currentIndex, d, n);
          nextValue = a[nextIndex];
          a[nextIndex] = currentValue;
        }
      }
    } else {
      // The following algorithm serves by putting
      // the nextIndex/nextValue into a temporary variables. This make O(1) space.
      // Visualization: there is a rabbit jump by 'd' distance for every 'step'
      // by n steps, the rabbit should visit all the square
      // with the exception of gcd(n d) != 1. At the exception
      // the rabbit would run in 'circle' after n/gcd(n,d) steps.
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

  static int gcd(int a, int b) {
    while (a != b) {
      if (a > b) {
        a = a - b;
      } else {
        b = b - a;
      }
    }
    return a;
  }

  public static void main(final String[] args) {
    System.out.println(Arrays.toString(leftRotation(new int[] {0, 1, 2, 3, 4, 5}, 2)));
    System.out.println(Arrays.toString(leftRotation(new int[] {0, 1, 2, 3, 4, 5}, 3)));
    System.out.println(Arrays.toString(leftRotation(new int[] {0, 1, 2, 3, 4, 5}, 4)));
    System.out.println(Arrays.toString(leftRotation(new int[] {0, 1, 2, 3, 4, 5, 6}, 4)));
    System.out.println(Arrays.toString(leftRotation(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}, 3)));
    System.out.println(Arrays.toString(leftRotation(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}, 4)));
    /*
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
    */
  }
}
