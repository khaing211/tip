package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/equal/
 *
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array
 */
public class QuadrupletEqual {
  public static ArrayList<Integer> equal(final ArrayList<Integer> a) {
    final ArrayList<Integer> result = new ArrayList<>();
    final Map<Integer, ArrayList<Integer>> sumToIndex = new HashMap<>();
    final int n = a.size();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        final int sum = a.get(i) + a.get(j);
        final ArrayList<Integer> p2 = new ArrayList<>(Arrays.asList(i, j));
        // System.out.println(sum + " " + p2);
        if (sumToIndex.containsKey(sum)) {

          final ArrayList<Integer> p1 = sumToIndex.get(sum);
          // System.out.println("Match sum " + sum + " " + p1);

          if (isValidMatch(p1, p2)) {
            final ArrayList<Integer> newResult = new ArrayList<>();
            newResult.addAll(p1);
            newResult.addAll(p2);

            if (result.isEmpty()) {
              // no contest since there is no result
              result.addAll(newResult);
            } else if (!lexicographicallyCompare(result, newResult)) {
              // contest for smaller lexographically comparison
              result.clear();
              result.addAll(newResult);
            }
          }
        } else {
          sumToIndex.put(sum, p2);
        }
      }
    }
    return result;
  }

  /**
   * This is to prevent reuse the same element / duplicate elements in the input array
   */
  static boolean isValidMatch(final ArrayList<Integer> p1, final ArrayList<Integer> p2) {
    final int a1 = p1.get(0);
    final int b1 = p1.get(1);
    final int c1 = p2.get(0);
    final int d1 = p2.get(1);
    return a1 < c1 && b1 != c1 && b1 != d1;
  }

  // Implementation a lexicographically comparison correctly is hard work!!!!

  // return true if a < b;
  static boolean lexicographicallyCompare(final ArrayList<Integer> a, final ArrayList<Integer> b) {
    //System.out.println("Compare " + a + " " + b);
    for (int i = 0; i < 4; i++) {
      if (a.get(i) == b.get(i)) {
        // defer the comparison to the next element
      } else if (a.get(i) < b.get(i)) {
        return true;
      } else if (a.get(i) > b.get(i)) {
        return false;
      }
    }
    // every element is equal so it is equal
    return true;
  }

  public static void main(final String[] args) {
    System.out.println(equal(new ArrayList<>(Arrays.asList(9, 5, 4, 9, 3, 6, 8, 7, 1, 2, 8, 7, 2, 9, 7, 1, 3, 9, 7, 8, 1, 0, 5, 5))));
  }
}
