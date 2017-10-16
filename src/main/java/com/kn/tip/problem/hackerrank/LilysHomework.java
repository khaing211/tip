package com.kn.tip.problem.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lilys-homework
 *
 * The problem assume distinct values and allow the constraint to be accounted for reverse sorted array.
 *
 * Sort the array, and use original index to work backward from supposedly sorted array to get the minimum swap.
 * No proof on why this approach would yield minimum swap, but the intuition is that this would only swap the elements
 * that need swapping.
 */
public class LilysHomework {
  static int countSwap(final Integer[] original, final Integer[] sorted,
      final Map<Integer, Integer> valueToIndex) {
    // System.err.println(Arrays.toString(original));
    // System.err.println(valueToIndex);
    int swap = 0;
    for (int i = 0; i < original.length; i++) {
      if (sorted[i] != original[i]) {
        swap++;

        final int from = valueToIndex.get(sorted[i]);
        final int to = i;

        // update copy as you go
        original[from] = original[to];
        original[to] = sorted[i];

        // Update Map index
        valueToIndex.put(sorted[i], i);
        valueToIndex.put(original[from], from);

        // System.err.println(Arrays.toString(original));
        // System.err.println(valueToIndex);
      }
    }
    return swap;
  }

  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    final int N = scanner.nextInt();
    final Integer[] sortedArray = new Integer[N];
    final Integer[] copy = new Integer[N];
    final Integer[] reverseSortedArray = new Integer[N];
    final Integer[] reverseCopy = new Integer[N];
    final Map<Integer, Integer> valueToIndex = new HashMap<>();
    for (int i = 0; i < N; i++) {
      sortedArray[i] = copy[i] = reverseSortedArray[i] = reverseCopy[i] = scanner.nextInt();
      valueToIndex.put(sortedArray[i], i);
    }

    final Map<Integer, Integer> reverseValueToIndex = new HashMap<>(valueToIndex);
    Arrays.sort(sortedArray);
    Arrays.sort(reverseSortedArray, Collections.reverseOrder());


    System.out.println(Math.min(countSwap(copy, sortedArray, valueToIndex),
        countSwap(reverseCopy, reverseSortedArray, reverseValueToIndex)));
  }
}
