package com.kn.tip.problem.codewars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SumDigPower {
  public static List<Long> sumDigPow(final long a, final long b) {
    return LongStream.rangeClosed(Math.max(a, 0), Math.max(b, 0))
        .sequential()
        .boxed()
        .filter(SumDigPower::eureka)
        .collect(Collectors.toList());
  }

  public static boolean eureka(final long x) {
    long s = 0;
    final String k = Long.toString(x);
    for (int i = 0; i < k.length(); i++) {
      s += (long) Math.pow(k.charAt(i) - '0', i + 1);
    }
    return s == x;
  }
}
