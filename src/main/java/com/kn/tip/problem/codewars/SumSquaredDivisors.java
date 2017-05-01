package com.kn.tip.problem.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SumSquaredDivisors {

  // The result will be an array of arrays(in C an array of Pair), each subarray having two elements,
  // first the number whose squared divisors is a square and then the sum of the squared divisors.
  // list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
  // list_squared(42, 250) --> [[42, 2500], [246, 84100]]
  public static String listSquared(final long m, final long n) {
    final List<List<Long>> result = LongStream.rangeClosed(m, n)
      .mapToObj(l -> toValAndSumSquaredFactorization(l))
      .filter(list -> isSquare(list.get(1)))
      .collect(Collectors.toCollection(ArrayList::new));
    return result.toString();
  }

  public static boolean isSquare(final long val) {
    final long sqrt = (long)Math.sqrt(val);
    //System.out.println(sqrt + " " + val);
    return sqrt*sqrt == val;
  }

  private static List<Long> toValAndSumSquaredFactorization(final long val) {
    final List<Long> ret = new ArrayList<>();
    ret.add(val);
    ret.add(sumSquaredFactorization(val));
    return ret;
  }

  private static long sumSquaredFactorization(final long val) {
    long sum = 0;
    for (long i = 1; i*i <= val; i++) {
      if (val % i == 0) {
        final long q = val / i;
        sum += i*i;
        if (i != q) {
          sum += q*q;
        }
      }
    }
    return sum;
  }

  public static void main(final String[] args) {
    System.out.println(SumSquaredDivisors.listSquared(1, 250));
    System.out.println(SumSquaredDivisors.listSquared(42, 250));
  }
}
