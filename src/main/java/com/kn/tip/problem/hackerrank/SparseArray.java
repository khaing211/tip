package com.kn.tip.problem.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays
 */
public class SparseArray {
  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int n = Integer.valueOf(scanner.nextLine());
    final Map<String, Integer> wordFrequency = new HashMap<>();
    for (int i = 0; i < n; i++) {
      final String word = scanner.nextLine();
      wordFrequency.compute(word, (k, v) -> v == null ? 1 : v + 1);
    }
    final int q = Integer.valueOf(scanner.nextLine());
    for (int i = 0; i < q; i++) {
      final String word = scanner.nextLine();
      System.out.println(wordFrequency.getOrDefault(word, 0));
    }
  }
}
