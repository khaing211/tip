package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

public class DiagonalDifference {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int tmp = scanner.nextInt();
        if (i == j) {
          sum += tmp;
        }

        if (n - j - 1 == i) {
          sum -= tmp;
        }
      }
    }

    System.out.println(Math.abs(sum));
  }
}
