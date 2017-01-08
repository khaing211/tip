package com.kn.tip.problem.codewars;

public class Multiple3And5 {
  public int solution(final int number) {
    // arthimetic series sum
    final int n3 = (number-1)/3;
    final int n5 = (number-1)/5;
    final int n15 = (number-1)/15;
    return sum(n3, 3) + sum(n5, 5) - sum(n15, 15);
  }

  private int sum(final int n, final int d) {
    // 1st term is 0 in the series
    return d*n*(n+1)/2;
  }
}
