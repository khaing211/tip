package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
 *
 * Use Map<> sum -> index for start and end index
 */
public class LargestContinousSequenceSumToZero {
  public static ArrayList<Integer> lszero(final ArrayList<Integer> a) {
    final int n = a.size();
    final Map<Integer, Integer> sumToStartIndex = new HashMap<>();
    final Map<Integer, Integer> sumToLastIndex = new HashMap<>();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a.get(i);
      if (sumToStartIndex.containsKey(sum)) {
        sumToLastIndex.put(sum, i);
      } else {
        sumToStartIndex.put(sum, i);
      }
    }
    System.out.println(sumToStartIndex);
    System.out.println(sumToLastIndex);

    int bestStartIndexSoFar = n;
    int bestLastIndexSoFar = n;

    // If there is a first sum 0, use it
    if (sumToStartIndex.containsKey(0)) {
      bestStartIndexSoFar = 0;
      bestLastIndexSoFar = sumToStartIndex.get(0);
    }

    for (final Map.Entry<Integer, Integer> lastIndexEntry : sumToLastIndex.entrySet()) {
      final int currentSum = lastIndexEntry.getKey();
      final int lastIndex = lastIndexEntry.getValue();
      // if the sum is zero in sumToLastIndex map, then should use startIndex = 0
      final int startIndex = currentSum == 0 ? 0 : sumToStartIndex.get(currentSum) + 1;
      final int bestLengthSoFar = bestLastIndexSoFar - bestStartIndexSoFar;
      final int currentBestLengthSoFar = lastIndex - startIndex;
      System.out.println(startIndex + " " + lastIndex + " " + bestStartIndexSoFar + " " + bestLastIndexSoFar);
      if (currentBestLengthSoFar == bestLengthSoFar && bestStartIndexSoFar > startIndex) {
        bestStartIndexSoFar = startIndex;
        bestLastIndexSoFar = lastIndex;
      } else if (currentBestLengthSoFar > bestLengthSoFar) {
        bestStartIndexSoFar = startIndex;
        bestLastIndexSoFar = lastIndex;
      }
    }

    final ArrayList<Integer> result = new ArrayList<>();
    // Check to see if there is any zero at all
    if (bestLastIndexSoFar != n) {
      for (int i = bestStartIndexSoFar; i <= bestLastIndexSoFar; i++) {
        result.add(a.get(i));
      }
    }
    return result;
  }

  public static void main(final String[] args) {
    final ArrayList<Integer> a = new ArrayList<>(Arrays.asList(15, -25, 10, -8, -15, 14, -11, 12, 25, 26, -15, -23, -7, -7, 20, 21, -7, -15));
    System.out.println(lszero(a));
  }
}
