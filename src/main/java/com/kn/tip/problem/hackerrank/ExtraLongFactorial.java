package com.kn.tip.problem.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials
 * BigInteger/BigDecimal are immutable.
 */
public class ExtraLongFactorial {
  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int n = scanner.nextInt();
    BigInteger factorial = BigInteger.ONE;
    for (int i = 1; i <= n; i++) {
      factorial = factorial.multiply(BigInteger.valueOf(i));
    }
    System.out.println(factorial);
  }
}
