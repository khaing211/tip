package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/counting-valleys
 */
public class CountingValley {
  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final String n = scanner.nextLine();
    final String steps = scanner.nextLine();
    int altitude = 0;
    int valley = 0;
    for (int i = 0; i < steps.length(); i++) {
      if (steps.charAt(i) == 'D') {
        altitude--;
      } else if (steps.charAt(i) == 'U') {
        // when you climb up to sea level
        // then, you are escaping a valley
        if (altitude + 1 == 0) {
          valley++;
        }
        altitude++;
      }
    }
    System.out.println(valley);
  }
}
