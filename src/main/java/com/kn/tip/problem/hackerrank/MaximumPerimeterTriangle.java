package com.kn.tip.problem.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Print sides of triangle with maximum perimeter triangle
 * given n sticks of length to form the triangle.
 */
public class MaximumPerimeterTriangle {
  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int n = scanner.nextInt();
    final int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = scanner.nextInt();
    }

    Arrays.sort(array);
    for (int i = n - 1; i >= 2; i--) {
      if (array[i - 1] + array[i - 2] > array[i]) {
        for (int j = i - 2; j <= i; j++) {
          System.out.print(array[j] + " ");
        }
        System.out.println();
        return;
      }
    }

    System.out.println(-1);
  }
}
