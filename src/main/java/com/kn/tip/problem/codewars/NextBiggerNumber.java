package com.kn.tip.problem.codewars;

import java.util.Arrays;

/**
 * You have to create a function that takes a positive integer number and returns the next bigger number formed by the same digits:

Kata.nextBiggerNumber(12)==21
Kata.nextBiggerNumber(513)==531
Kata.nextBiggerNumber(2017)==2071
If no bigger number can be composed using those digits, return -1:

Kata.nextBiggerNumber(9)==-1
Kata.nextBiggerNumber(111)==-1
Kata.nextBiggerNumber(531)==-1
 * @author developer
 *
 */
public class NextBiggerNumber {

  public static long nextBiggerNumber(final long n) {
    final String s = Long.toString(n);
    final char[] val = s.toCharArray();

    // The least significant digit is the right most
    // The most significant digit is the left most.
    // The largest number would have the digits arrange in strictly decreasing
    // The smallest number would have the digits arrange in strictly increasing (with exception of '0' in the front)

    // Scan right to left, find any segment that is increasing
    // Then sort that pivot to the right most in increasing manner
    // That would be your next bigger number
    int pivot = val.length - 2;
    while (pivot >= 0) {
      if (val[pivot] < val[pivot + 1]) {
        break;
      }
      pivot--;
    }

    final boolean foundPivot = pivot >= 0;
    if (!foundPivot) {
      return -1;
    }

    final int immediateBiggerDigitIndex = findImmediateBiggerDigitIndex(val, val[pivot], pivot+1, pivot+2);
    swap(val, pivot, immediateBiggerDigitIndex);

    final char[] prefix = Arrays.copyOfRange(val, 0, pivot+1);
    final char[] suffix = Arrays.copyOfRange(val, pivot+1, val.length);
    return Long.valueOf(new String(prefix) + getSmallestNumber(suffix));
  }

  private static int findImmediateBiggerDigitIndex(final char[] val, final char minExclusive, final int maxInclusiveIndex, final int fromIndex) {
    int ret = maxInclusiveIndex;
    for (int i = fromIndex; i < val.length; i++) {
      if (val[i] > minExclusive && val[i] <= val[ret]) {
        ret = i;
      }
    }
    return ret;
  }

  private static void swap(final char[] val, final int ix, final int iy) {
    final char tmp = val[ix];
    val[ix] = val[iy];
    val[iy] = tmp;
  }

  private static String getSmallestNumber(final char[] val) {
    Arrays.sort(val);
    return new StringBuilder(new String(val)).toString();
  }

  public static void main(final String[] args) {
    long val = 2017;
    do {
      System.out.println(val = nextBiggerNumber(val));
    } while (val != -1);

    System.out.println(NextBiggerNumber.nextBiggerNumber(12));
    System.out.println(NextBiggerNumber.nextBiggerNumber(513));
    System.out.println(NextBiggerNumber.nextBiggerNumber(414));
    System.out.println(NextBiggerNumber.nextBiggerNumber(144));
  }
}
