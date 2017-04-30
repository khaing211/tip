package com.kn.tip.problem.codewars;

import java.util.Arrays;

public class GapInPrimes {
  public static long[] gap(final int g, final long m, final long n) {
    // by problem definition, m > 2 (not 2)
    System.out.println(Arrays.toString(new long[] {g, m, n}));
    final long adjustedM = m % 2 == 0 ? m + 1: m;
    long i = adjustedM;
    while (i <= n - g) {
      final boolean isIndexPrime = isPrime(i);
      final boolean isIndexOffsetGPrime = isPrime(i+g);
      final long largestPrimeInBetween = findLargestPrimeBetween(i+1, i+g-1);
      final boolean isPrimeExistInGap = largestPrimeInBetween != 0;

      if (isIndexPrime && isIndexOffsetGPrime && !isPrimeExistInGap) {
        return new long[] {i, i+g};
      }

      i = isIndexOffsetGPrime ? i+g : i+2;
    }
    return null;
  }

  // Brute force isPrime
  public static boolean isPrime(final long num) {
      if (num == 2) {
        return true;
      }
      if (num % 2 == 0) {
        return false;
      }
      for (long i = 3; i * i <= num; i += 2) {
        if (num % i == 0) {
          return false;
        }
      }
      return true;
  }

  public static long findLargestPrimeBetween(final long from, long to) {
    while (to >= from) {
      if (isPrime(to)) {
        return to;
      }
      to--;
    }
    return 0;
  }
}
