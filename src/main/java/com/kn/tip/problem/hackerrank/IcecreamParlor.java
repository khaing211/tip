package com.kn.tip.problem.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor
 */
public class IcecreamParlor {
  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      final int m = scanner.nextInt();
      final int n = scanner.nextInt();
      final Map<Integer, Integer> pricesToId = new HashMap<>();
      boolean found = false;
      // This work, because the problem didn't specify which two ids in the case of
      // duplication. If duplicate was the answer, that means the 1st value must be encountered
      // and the sum = 2x, then 2nd value is encountered, we will use the hash map
      // to find the 1st value.
      for (int i = 1; i <= n; i++) {
        final int c = scanner.nextInt();
        final int c1 = m - c;
        if (!found && pricesToId.containsKey(c1)) {
          System.out.println(String.format("%d %d", pricesToId.get(c1), i));
          found = true;
        }
        pricesToId.put(c, i);
      }

      // This is a good algorithm to find 2 values that sum to x in a sorted array
      // Since it is sorted, it lost the identifier, which is the position of the value

      /*final int[] c = new int[n];
      for (int i = 0; i < n; i++) {
          c[i] = scanner.nextInt();
      }
      Arrays.sort(c);
      int i = 0;
      int j = n-1;
      while (i < j) {
          if (c[i] + c[j] == m) {
              System.out.println(String.format("%d %d", i+1, j+1));
              break;
          } else if (c[i] + c[j] > m) {
              j--;
          } else {
              i--;
          }
      }
      */
    }
  }
}
