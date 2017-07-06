package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

public class SuperReducedString {
  static String super_reduced_string(String s) {
    final StringBuilder builder = new StringBuilder();
    for (char c = 'a'; c <= 'z'; c++) {
      builder.append(c).append(c).append("|");
    }
    builder.setLength(builder.length() - 1);
    final String regex = builder.toString();
    String newString = s;
    do {
      s = newString;
      // if not using replaceAll, we could reduce to O(n) rather than O(n^2)
      // because String#equals is O(n) execute per replaceAll which is O(n)
      // TODO: Using a builder and your old replace could reduce to O(n).
      newString = s.replaceAll(regex, "");
    } while (!newString.equals(s));

    if (newString.isEmpty()) {
      return "Empty String";
    } else {
      return newString;
    }
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final String s = in.next();
    final String result = super_reduced_string(s);
    System.out.println(result);
  }
}
