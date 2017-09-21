package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/repeated-string
 */
public class RepeatedString {
  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final String s = in.next();
    final long n = in.nextLong();
    final long len = s.length();
    final long repeatedN = n / len;
    final long remainN = n % len;
    final String subS = s.substring(0, (int) remainN);
    final long count = s.replaceAll("[^a]", "").length();
    final long countSubS = subS.replaceAll("[^a]", "").length();
    System.err.println(count + " " + repeatedN + " " + countSubS);
    System.out.println(count * repeatedN + countSubS);
  }
}
