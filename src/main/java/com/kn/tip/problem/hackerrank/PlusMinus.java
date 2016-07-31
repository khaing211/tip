package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

public class PlusMinus {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int pos = 0;
    int neg = 0;
    int zero = 0;

    for (int i = 0; i < n; i++) {
      int tmp = scanner.nextInt();
      if (tmp > 0) {
        pos++;
      } else if (tmp < 0) {
        neg++;
      } else {
        zero++;
      }
    }

    System.out.println(((double) pos) / n);
    System.out.println(((double) neg) / n);
    System.out.println(((double) zero) / n);
  }
}
