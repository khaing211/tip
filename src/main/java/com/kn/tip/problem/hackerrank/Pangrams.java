package com.kn.tip.problem.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pangrams
 */
public class Pangrams {
  public static void main(final String args[]) throws Exception {
    final Scanner scanner = new Scanner(System.in);
    final String line = scanner.nextLine();
    final int[] counts = new int['z' - 'a' + 1];
    for (int i = 0; i < line.length(); i++) {
      if (Character.isLetter(line.charAt(i))) {
        counts[Character.toLowerCase(line.charAt(i)) - 'a']++;
      }
    }
    System.err.println(Arrays.toString(counts));
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] == 0) {
        System.out.println("not pangram");
        return;
      }
    }
    System.out.println("pangram");
  }
}
