package com.kn.tip.problem.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/permutation-equation
 * Could have used int[] but did not understand it is distinct sequence value.
 */
public class SequenceEquation {
  public static void main(final String args[]) throws Exception {
    final Scanner scanner = new Scanner(System.in);
    final int N = scanner.nextInt();
    final Map<Integer, Integer> valueToIndex = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      valueToIndex.put(scanner.nextInt(), i);
    }

    for (int i = 1; i <= N; i++) {
      System.out.println(valueToIndex.get(valueToIndex.get(i)));
    }
  }
}
