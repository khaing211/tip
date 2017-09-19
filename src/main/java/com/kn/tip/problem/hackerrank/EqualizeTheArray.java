package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/equality-in-a-array
 *
 * Karl has an array of  integers defined as . In one operation, he can delete any element from the array.
 *
 * Karl wants all the elements of the array to be equal to one another. To do this, he must delete zero or
 * more elements from the array. Find and print the minimum number of deletion operations Karl must perform
 * so that all the array's elements are equal.
 *
 * level: Easy
 */
public class EqualizeTheArray {
  @SuppressWarnings("resource")
  public static void main(final String[] args) {
    // value is between 1 and 100
    final int[] count = new int[101];
    final Scanner scanner = new Scanner(System.in);
    final int len = scanner.nextInt();
    for (int i = 0; i < len; i++) {
        count[scanner.nextInt()]++;
    }
    // Get the the value that has most count and delete the rest
    int maxCount = 0;
    for (int i = 1; i < count.length; i++) {
        maxCount = Math.max(maxCount, count[i]);
    }
    System.out.println(len - maxCount);
  }
}
