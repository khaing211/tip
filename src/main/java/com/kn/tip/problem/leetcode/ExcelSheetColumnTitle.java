package com.kn.tip.problem.leetcode;

public class ExcelSheetColumnTitle {
  // offset by 1
  public static String convertToTitle(int n) {
    final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

    StringBuilder builder = new StringBuilder(26);
    while (n > 0) {
      char ch = alphabet[(n - 1) % 26];
      builder.append(ch);
      n = (n - 1) / 26;
    }

    return builder.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(convertToTitle(28));
    System.out.println(convertToTitle(1));
    System.out.println(convertToTitle(55));

    System.out.println(convertToTitle(1000));
    System.out.println(convertToTitle(18253));
  }
}
