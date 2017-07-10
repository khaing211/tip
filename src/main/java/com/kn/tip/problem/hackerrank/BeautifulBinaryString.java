package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-binary-string
 */
public class BeautifulBinaryString {
  static boolean isMatch(final int index, final int[] bits) {
    return bits[index] == 0 && bits[index - 1] == 1 && bits[index - 2] == 0;
  }

  static int minSteps(final int n, final String B) {
    if (B.length() < 3) {
      return 0;
    }

    final int[] bits = new int[B.length()];
    for (int i = 0; i < B.length(); i++) {
      bits[i] = B.charAt(i) - '0';
    }

    int count = 0;
    for (int i = 2; i < bits.length; i++) {
      if (isMatch(i, bits)) {
        // better conversion than 1 to 0
        bits[i] = 1;
        count++;
      }
    }
    return count;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final String B = in.next();
    final int result = minSteps(n, B);
    System.out.println(result);
  }
}
